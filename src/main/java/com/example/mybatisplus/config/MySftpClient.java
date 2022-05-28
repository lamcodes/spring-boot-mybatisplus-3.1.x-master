package com.example.mybatisplus.config;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * @author zkp
 * @date 2022/5/26 20:43
 */
@Slf4j
public class MySftpClient {


    //其实可以不用常亮，不过个人还是喜欢用常亮
    public static final String URL = "107.172.217.24";
    public static final int PORT = 21;
    public static final String USERNAME = "root";
    public static final String PASSWORD = "zhang19991118";

//    /**
//     * @param path FTP服务器保存目录
//     * @param filename 上传到FTP服务器上的文件名
//     * @param input 输入流
//     * @return 成功返回true，否则返回false
//     */
    public static boolean uploadFile(String path, String filename, InputStream input) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            //在这里开始连接服务器，上面定的常亮这里就可以用了
            ftp.connect(URL, PORT);    //如果是默认端口，可以用ftp.connect(url)直接连接
            ftp.login(USERNAME, PASSWORD);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            System.out.println("文件开始传输。。。");

            System.out.println("当前工作目录：" + ftp.printWorkingDirectory());
            ftp.changeWorkingDirectory(path);
            System.out.println("更改后的工作目录：" + ftp.printWorkingDirectory());
            //如果是多媒体的话，这里需要转为二进制形式传输，不然会失真（抄的作业，我也不知道为啥会失真，可能是FTP是以文本的形      式传输的吧）
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //文件夹转移到文件夹，文件转移为文件。被传输的父路径需要存在，不然不能传输。文件夹的话，文件夹可以不存在。
            boolean rename = ftp.rename("111.txt", "/root/job/xt.txt");
            if (rename){
                System.out.println("文件传输成功");
            }
            //上面都没啥复杂的，主要说说这里ftp.storeFile
            //上传的时候（尤其是多媒体文件），有时候没问题，正常返回是true，有时候上传成功了，但返回的确实false，这里就需要加ftp.enterLocalPassiveMode();这个方法了，理由其实很简单，官方的大致意思就是，告诉服务器打开客户端要连接到的数据端口
//            ftp.enterLocalPassiveMode();
//            ftp.storeFile(filename, input);
            //记得关闭
            input.close();
            ftp.logout();
            success = true;
        } catch ( IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    public static void main(String[] args) {
        listFileNames("107.172.217.24", 22, "root", "zhang19991118", "/root/zkp/");
    }
    private static List<String> listFileNames(String host, int port, String username, final String password, String dir) {
        List<String> list = new ArrayList<String>();
        ChannelSftp sftp = null;
        Channel channel = null;
        Session sshSession = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            log.debug("Session connected!");
            channel = sshSession.openChannel("sftp");
            channel.connect();
            log.debug("Channel connected!");
            sftp = (ChannelSftp) channel;

            Vector<?> vector = sftp.ls(dir);
            for (Object item:vector) {
                ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) item;
                System.out.println(entry.getFilename());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeChannel(sftp);
            closeChannel(channel);
            closeSession(sshSession);
        }
        return list;
    }

    private static void closeChannel(Channel channel) {
        if (channel != null) {
            if (channel.isConnected()) {
                channel.disconnect();
            }
        }
    }

    private static void closeSession(Session session) {
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }


}
