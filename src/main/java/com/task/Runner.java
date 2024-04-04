package com.task;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.model.MyObject;
import com.service.MyThread01;
import com.service.MyThread02;
import com.util.ThreadPoolUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class Runner implements CommandLineRunner{


    @Override
    public void run(String... strings) throws Exception {
        ThreadPoolUtil.threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "你好！！！！";
            }
        });

        CommonTask commonTask = new CommonTask();
        FutureTask<String> stringFutureTask = new FutureTask<>(commonTask);
        stringFutureTask.run();
        stringFutureTask.get();

        MyObject myObject = new MyObject();
        new MyThread01(myObject).start();
        new MyThread02(myObject).start();



    }
}
