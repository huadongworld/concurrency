package com.hd.concurrency.example.singleton;

import com.hd.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 *
 * @author HuaDong
 * @date 2019/9/16 16:41
 */
@ThreadSafe
public class SingletonExample2 {

    /**
     * 私有构造函数
     */
    private SingletonExample2() {

    }

    /**
     * 单例对象
     */
    private static SingletonExample2 instance = new SingletonExample2();

    /**
     * 静态的工厂方法
     *
     * @return
     */
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
