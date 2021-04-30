package com.hewon.random;

import java.util.Random;

/**
 * jdk7之前使用的Random类
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }

    }
}
