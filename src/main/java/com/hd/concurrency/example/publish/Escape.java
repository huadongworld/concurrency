package com.hd.concurrency.example.publish;

import com.hd.concurrency.annotations.NotRecommend;
import com.hd.concurrency.annotations.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HuaDong
 * @date 2019/9/17 18:20
 */
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(Escape.class);

    public Escape () {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            LOGGER.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
