package com.attanfan.juc.study;
/**
 * 一句话：收集七颗龙珠召唤神龙
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static final int PARTIES = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTIES,()->{System.out.println("召唤神龙");});

        for (int i = 1 ; i <=7 ; i++) {
            final int tempInt = i;
             new Thread(()->{
                 System.out.println(Thread.currentThread().getName()+"\t收集第"+tempInt+"几颗龙珠");
                 try {
                     cyclicBarrier.await();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 } catch (BrokenBarrierException e) {
                     e.printStackTrace();
                 }
             },String.valueOf(i)).start();
        }
    }
}
