package com.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumTask implements Runnable{

    private int i = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    //注意这里使用object对象作为锁
    private final Object object = new Object();

    @Override
    public void run() {
        while (true) {
            //加锁
            lock.lock();
            try {
                condition.signal();
                if (i < 100) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                } else {
                    break;
                }
                condition.await();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //解锁
                lock.unlock();

            }
        }
    }


//    @Override
//    public void run() {
//        while (true){
//            synchronized (object) {
//                object.notify();
//                if(i < 100){
//                    i++;
//                    System.out.println(Thread.currentThread().getName()+"---"+i);
//                }else{
//                    break;
//                }
//                try {
//                    object.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
