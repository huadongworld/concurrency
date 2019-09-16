package com.hd.concurrency.example.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HuaDong
 * @date 2019/9/15 11:38
 */
public class SynchronizedExample2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(SynchronizedExample1.class);

    /**
     * 修饰一个类
     *
     * @param j 标识
     */
    public static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    //每次循环睡50毫秒
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOGGER.info("test1 {} - {}", j, i);
            }
        }
    }

    /**
     * 修饰一个静态方法
     *
     * @param j 标识
     */
    public static synchronized void test2(int j) {
        for (int i = 0; i < 5; i++) {
            try {
                //每次循环睡50毫秒
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(
                () -> test2(1)
        );
        executorService.execute(
                () -> test2(2)
        );
    }
}
