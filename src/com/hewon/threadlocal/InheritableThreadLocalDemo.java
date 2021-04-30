package com.hewon.threadlocal;

/**
 * 对于ThreadLocal中子线程不能获取父线程内容问题的解决
 */
public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        new Thread();
    }
}
