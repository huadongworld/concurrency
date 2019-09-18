package com.hd.concurrency.example.threadlocal;

/**
 * @author HuaDong
 * @date 2019/9/18 21:38
 */
public class RequestHolder {

    private final static ThreadLocal<Long> REQUEST_HOLDER = new ThreadLocal<>();

    public static void add(Long id) {
        REQUEST_HOLDER.set(id);
    }

    public static Long getId() {
        return REQUEST_HOLDER.get();
    }

    public static void remove() {
        REQUEST_HOLDER.remove();
    }
}
