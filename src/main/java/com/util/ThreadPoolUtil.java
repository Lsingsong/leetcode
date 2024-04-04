package com.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1, 2, 0L, TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(5), new ThreadFactoryBuilder().setNameFormat("test-task-pool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());
}
