package com.hewon.myThread;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JoinDemo {
    private static final Lock lock = new ReentrantLock();
    @Test
    public void SleepInterrupted(){
        Thread threadOne = new Thread(()->{
            lock.lock();
            try {
                System.out.println("ThreadOne is Sleeping!");
                Thread.sleep(10000);
                System.out.println("ThreadOne has been awaked!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        Thread threadTwo = new Thread(()->{
            lock.lock();
            try {
                System.out.println("ThreadTwo is Sleeping!");
                Thread.sleep(10000);
                System.out.println("ThreadTwo has been awaked!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        threadOne.start();
        threadTwo.start();
    }
    @Test
    public void JoinInterrupted(){
        Thread threadOne = new Thread(()->{
            System.out.println("ThreadOne is running");
            for(;;){}
        });
        final Thread mainThread = Thread.currentThread();
        System.out.println("mainThread-->"+ mainThread);
        Thread threadTwo = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainThread.interrupt();
        });

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        Thread threadOne = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadOne Started");
        });
        Thread threadTwo = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadTwo Started");
        });
        threadOne.start();
        threadTwo.start();
        System.out.println("Wait all threads end");
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads ended");

        threadOne.interrupt();
    }


}
