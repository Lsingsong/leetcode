package com.task;

import com.util.ThreadPoolUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
public class CommonTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "xxx111";
    }
}
