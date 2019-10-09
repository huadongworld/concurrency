package com.hd.concurrency.example.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author HuaDong
 * @date 2019/10/9 9:47
 */
public class FutureExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(FutureExample.class);

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            LOGGER.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        LOGGER.info("do something in main");
        Thread.sleep(1000);
        String result = future.get();
        LOGGER.info("result：{}", result);
    }
}
