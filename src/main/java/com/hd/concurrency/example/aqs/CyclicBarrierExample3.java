package com.hd.concurrency.example.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HuaDong
 * @date 2019/10/9 9:45
 */
public class CyclicBarrierExample3 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CyclicBarrierExample3.class);

    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        LOGGER.info("callback is running");
    });

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    LOGGER.error("exception", e);
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        LOGGER.info("{} is ready", threadNum);
        barrier.await();
        LOGGER.info("{} continue", threadNum);
    }
}
