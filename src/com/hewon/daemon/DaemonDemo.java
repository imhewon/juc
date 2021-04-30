package com.hewon.daemon;

public class DaemonDemo {
    public static void main(String[] args) {
//        genDaemonThread();
        Thread userThread = new Thread(()->{
            for (;;){}
        });

        // 将用户线程标记为守护线程
        userThread.setDaemon(true);
        userThread.start();
        System.out.println(Thread.currentThread() + "is over.");


    }

    /**
     * 生成一个守护线程
     */
    private static void genDaemonThread() {
        Thread daemonThread = new Thread(()->{
            System.out.println("This is a daemon thread.");
        });

        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
