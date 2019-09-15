package com.hd.concurrency.example.atomic;

import com.hd.concurrency.annotations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author HuaDong
 * @date 2019/9/15 11:26
 */
@ThreadSafe
public class AtomicExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    private static final Logger LOGGER = LoggerFactory.getLogger(AtomicExample4.class);

    public static void main(String[] args) {
        count.compareAndSet(0, 2); // 2
        count.compareAndSet(0, 1); // no
        count.compareAndSet(1, 3); // no
        count.compareAndSet(2, 4); // 4
        count.compareAndSet(3, 5); // no
        LOGGER.info("count:{}", count.get());
    }
}
