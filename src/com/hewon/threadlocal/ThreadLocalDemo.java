package com.hewon.threadlocal;

/**
 * ThreadLocal API的使用
 */
public class ThreadLocalDemo {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();
    public static void main(String[] args) {
        new InheritableThreadLocalDemo();
    }
}
