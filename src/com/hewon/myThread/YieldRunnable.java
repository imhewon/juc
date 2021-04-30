package com.hewon.myThread;

import java.util.Timer;

public class YieldRunnable implements Runnable{
    YieldRunnable(){
        Thread thread = new Thread(this);
        thread.start();
        thread.interrupted();
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 5 == 0){
                System.out.println(Thread.currentThread() + "让出CPU时间片");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + "当前线程执行结束");
    }

    public static void main(String[] args) {
        new YieldRunnable();
        new YieldRunnable();
        new YieldRunnable();
    }
}
