package com.attanfan.juc.study;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 一句话：停车场抢车位
 */
public class SemaphoreDemo {
    public static final int PERMITS = 3;
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(PERMITS);

        for (int i = 1; i <=6 ; i++) {
             new Thread(()->{
                 try {
                     semaphore.acquire();
                     System.out.println(Thread.currentThread().getName()+"\t占到车位");
                     //暂停一会线程
                     try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
                     System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 } finally {
                     semaphore.release();
                 }
             },String.valueOf(i)).start();

        }

    }
}
