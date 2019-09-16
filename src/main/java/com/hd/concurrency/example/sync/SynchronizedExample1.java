package com.hd.concurrency.example.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HuaDong
 * @date 2019/9/15 11:37
 */
public class SynchronizedExample1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(SynchronizedExample1.class);

    /**
     * 修饰一个代码块
     *
     * @param j 标识
     */
    public void test1(int j) {
        synchronized (this) {
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
     * 修饰一个方法
     *
     * @param j 标识
     */
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
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
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(
                () -> example1.test1(1)
        );
        executorService.execute(
                () -> example2.test1(2)
        );
    }
}
