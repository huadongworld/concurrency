package com.hd.concurrency.example.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author HuaDong
 * @date 2019/10/9 9:48
 */
public class FutureTaskExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(FutureTaskExample.class);

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                LOGGER.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });

        new Thread(futureTask).start();
        LOGGER.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        LOGGER.info("result：{}", result);
    }
}
