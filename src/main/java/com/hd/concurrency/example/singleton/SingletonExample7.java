package com.hd.concurrency.example.singleton;

import com.hd.concurrency.annotations.Recommend;
import com.hd.concurrency.annotations.ThreadSafe;

/**
 * 枚举模式：最安全
 *
 * @author HuaDong
 * @date 2019/9/16 17:00
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    /**
     * 私有构造函数
     */
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {

        /**
         * 实例
         */
        INSTANCE;

        private SingletonExample7 singleton;

        /**
         * JVM保证这个方法绝对只调用一次
         */
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
