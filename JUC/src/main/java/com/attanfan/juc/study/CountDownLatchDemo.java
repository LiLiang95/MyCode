package com.attanfan.juc.study;

import com.attanfan.juc.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo
{
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t国被灭了");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t@@@@@@@@@@@@@@@@一统华夏");

    }


    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6; i++) {
             new Thread(()->{
                 System.out.println(Thread.currentThread().getName()+"\t同学离开教室");
                 countDownLatch.countDown();
             },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t@@@@@@@@@@@@@@@@班长关门走人");
    }
}

