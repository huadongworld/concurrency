package com.hd.concurrency.example.singleton;

import com.hd.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 *
 * @author HuaDong
 * @date 2019/9/16 16:59
 */
@ThreadSafe
public class SingletonExample6 {

    /**
     * 私有构造函数
     */
    private SingletonExample6() {

    }

    /**
     * 单例对象
     */
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    /**
     * 静态的工厂方法
     */
    public static SingletonExample6 getInstance() {
        return instance;
    }
}
