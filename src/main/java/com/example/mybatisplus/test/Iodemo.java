package com.example.mybatisplus.test;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author zkp
 * @Date 2022-06-16 18:40
 */
public class Iodemo {
    public static void main(String[] args) throws Exception {
//    t1();
        t6();
    }

    /**
     * 字节流和字符流都有对应的缓冲流，buffed开头如BufferedOutputStream, BufferedReader
     * @throws Exception
     */
    public static void t1() throws Exception {
        File file = new File("data\\1.txt");
        File file1 = new File("data\\2.txt");

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream os = new FileOutputStream(file1,true);
//        FileWriter fileWriter = new FileWriter(file);
        byte[] bytes = new byte[1024];
        int temp ;
        long startTime = System.currentTimeMillis();
        while ((temp=inputStream.read(bytes))!=-1){
            os.write(bytes,0,temp);
        }
        long endTime = System.currentTimeMillis();
        long spendTime = endTime- startTime;
        System.out.println("花费时间："+TimeUnit.MILLISECONDS.toSeconds(spendTime)+"花费ms"+spendTime);
        inputStream.close();
        os.close();
    }
    public static void t2() throws Exception {
        File file = new File("data\\1.txt");
        File file1 = new File("data\\2.txt");

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream os = new FileOutputStream(file1,true);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(os);

        byte[] bytes = new byte[1024];
        int temp;
        long startTime = System.currentTimeMillis();
        while ((temp=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,temp);
        }
        long endTime = System.currentTimeMillis();
        long spendTime = endTime- startTime;
        System.out.println("花费时间："+TimeUnit.MILLISECONDS.toSeconds(spendTime)+"花费ms"+spendTime);
        inputStream.close();
        os.close();
    }

    public static void t3() throws Exception {
        File file = new File("data\\1.txt");
        File file1 = new File("data\\2.txt");

        Reader reader = new FileReader(file);
        Writer writer = new FileWriter(file1,true);

        char[] bytes = new char[1024];
        int temp;
        long startTime = System.currentTimeMillis();
        while ((temp=reader.read(bytes))!=-1){
            writer.write(bytes,0,temp);
        }
        long endTime = System.currentTimeMillis();
        long spendTime = endTime- startTime;
        System.out.println("花费时间："+TimeUnit.MILLISECONDS.toSeconds(spendTime)+"花费ms"+spendTime);
        reader.close();
        writer.close();
    }

    /**
     *     转换流可以设置字符编码，不是节点流。转换流可以把字节流转换为字符流。
     */

    public static void t4() throws Exception {
        File file = new File("data\\3.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream,"gbk");
        writer.write("天空之城");
        writer.close();
    }

    /**
     *     转换流可以设置字符编码，不是节点流。转换流可以把字节流转换为字符流。
     */
    public static void t5() throws Exception {
        File file = new File("data\\3.txt");
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream,"gbk");
        System.out.println(reader.getEncoding());
        char[] chars=new char[2000];
        int len ;
        while ((len=reader.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }
        reader.close();
    }

    /**
     * 字符的缓冲输入流可以直接读取一行。
     * 输出流是只能写一个字符串。
     * @throws Exception
     */
    public static void t6() throws Exception {
        File file = new File("data\\1.txt");
        File file1 = new File("data\\2.txt");

        Reader reader = new FileReader(file);
        Writer writer = new FileWriter(file1,true);
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        String temp;
        while ((temp=bufferedReader.readLine())!=null){
            System.out.println(temp);
        }
//        char[] bytes = new char[1024];
//        int temp;
//        long startTime = System.currentTimeMillis();
//        while ((temp=reader.read(bytes))!=-1){
//            writer.write(bytes,0,temp);
//        }
//        long endTime = System.currentTimeMillis();
//        long spendTime = endTime- startTime;
//        System.out.println("花费时间："+TimeUnit.MILLISECONDS.toSeconds(spendTime)+"花费ms"+spendTime);
//        reader.close();
//        writer.close();
    }
}
