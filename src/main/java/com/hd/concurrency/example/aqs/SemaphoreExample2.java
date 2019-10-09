package com.hd.concurrency.example.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author HuaDong
 * @date 2019/10/9 9:49
 */
public class SemaphoreExample2 {

    private final static int THREAD_COUNT = 20;

    private static final Logger LOGGER = LoggerFactory.getLogger(SemaphoreExample2.class);

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(3); // 获取多个许可
                    test(threadNum);
                    semaphore.release(3); // 释放多个许可
                } catch (Exception e) {
                    LOGGER.error("exception", e);
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        LOGGER.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
