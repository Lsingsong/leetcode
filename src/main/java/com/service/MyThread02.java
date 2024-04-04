package com.service;

import com.model.MyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MyThread02 extends Thread{

    //@Autowired
    MyObject myObject;

    public MyThread02(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        while (myObject.i <= 98 ) {
            synchronized (MyObject.class) {
                if(!myObject.flag) {
//                    try{
//                        myObject.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName()+"\t"+(++myObject.i));
                    myObject.flag = false;
                    //myObject.notify();
                }
            }
        }

    }
}
