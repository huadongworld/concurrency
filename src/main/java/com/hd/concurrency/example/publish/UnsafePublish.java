package com.hd.concurrency.example.publish;

import com.hd.concurrency.annotations.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author HuaDong
 * @date 2019/9/17 18:20
 */
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};

    private static final Logger LOGGER = LoggerFactory.getLogger(UnsafePublish.class);

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        LOGGER.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        LOGGER.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
