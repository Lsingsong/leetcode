package com.service;

public class PrintNumThread extends Thread {

    static int num = 0;
    static final Object object = new Object();

    @Override
    public void run() {

        while (true) {

            synchronized (object) {
                //唤醒等待的线程 必须在同步代码块中
                object.notify();
                if (num < 100) {
                    num++;
                    System.out.println(Thread.currentThread().getName()+":"+num);
                } else {
                    break;
                }
                try {
                    /*
                    wait()  必须在同步代码块中使用，
                            必须是使用同步锁调用wait()
                            wait()调用后，锁会释放
                            必须要通过其他线程来唤醒
                     */
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}