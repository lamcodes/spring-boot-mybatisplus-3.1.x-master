package com.example.mybatisplus.test;

import com.dtp.core.DtpRegistry;
import com.dtp.core.support.NamedRunnable;
import com.dtp.core.thread.DtpExecutor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author zkp
 * @Date 2022-07-03 15:03
 */
@SpringBootTest
@Slf4j
public class DynamicTest {


    @Test
    public void exec() {
        DtpExecutor dtpExecutor = DtpRegistry.getDtpExecutor("dtpExecutor1");
        for (int i = 0; i < 10; i++) {
            dtpExecutor.execute(NamedRunnable.of(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("i am dynamic-tp-test-2 task");
            }, "坤平平平-" + i));
        }


    }
}
