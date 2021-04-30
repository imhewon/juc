package com.hewon.deadlock;

import org.junit.Test;

public class DeadLockDemo {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();
    public static void main(String[] args) {
        Thread  threadA = new Thread(()->{
           synchronized (resourceA){
               System.out.println(Thread.currentThread() + "has got ResourceA");
               try {
                   // Let threadB get ResourceB.
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread() + "want to get ResourceB");
               synchronized (resourceB){
                   System.out.println(Thread.currentThread() + "has got ResourceB");
               }
           }
        });

        Thread  threadB = new Thread(()->{
            synchronized (resourceB){
                System.out.println(Thread.currentThread() + "has got ResourceB");
                try {
                    // Let threadB get ResourceB.
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "want to get ResourceA");
                synchronized (resourceA){
                    System.out.println(Thread.currentThread() + "has got ResourceA");
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
