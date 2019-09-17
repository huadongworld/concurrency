package com.hd.concurrency.example.singleton;

import com.hd.concurrency.annotations.NotRecommend;
import com.hd.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 *
 * @author HuaDong
 * @date 2019/9/16 16:53
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    /**
     * 私有构造函数
     */
    private SingletonExample3() {

    }

    /**
     * 单例对象
     */
    private static SingletonExample3 instance = null;

    /**
     * 静态的工厂方法
     *
     * @return
     */
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
