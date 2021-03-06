package com.attanfan.juc.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class MyThread implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("********come in call()");
        return 123;
    }
}


/**
 * java
 * 多线程中，第3种获得多线程的方式
 * 1：继承Thread类 （很少用）
 * 2：实现Runnable接口
 * 3：实现Callable接口
 */
public class CallableDemo
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        FutureTask<Integer> futureTask = new FutureTask( () -> {
            System.out.println("********come in call() lambdy express");
            return 200;
        });

        Thread t1 = new Thread(futureTask,"A");
        t1.start();

        System.out.println("********retValue: "+futureTask.get());


    }
}
