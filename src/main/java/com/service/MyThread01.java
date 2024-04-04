package com.service;

import com.model.MyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MyThread01 extends Thread{

    //@Autowired
    MyObject myObject;

    public MyThread01(MyObject myObject) {
        this.myObject = myObject;
    }

    public MyThread01() {

    }

    @Override
    public void run() {
        while (myObject.i <= 98 ) {
            synchronized (MyObject.class) {
                if(myObject.flag) {
//                    try{
//                        myObject.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName()+"\t"+(++myObject.i));
                    myObject.flag = true;
                    //myObject.notify();
                }
            }
        }

    }
}
