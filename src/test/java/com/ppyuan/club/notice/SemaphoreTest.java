package com.ppyuan.club.notice;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {


    public static void qq() {

        Semaphore semaphore = new Semaphore(2);
        try {
            semaphore.acquire(2);
        } catch (InterruptedException e) {

        }
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("----->子线程1执行");
                semaphore.release(1);
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("----->子线程2执行");
                semaphore.release(1);
            }
        });
        t1.start();
        t2.start();
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----->主线程执行");
        semaphore.release();

    }

    public static void main(String[] args) {
        for (int i = 0; i <10000 ; i++) {
            qq();
            System.out.println("-------------------");
        }
    }


}


