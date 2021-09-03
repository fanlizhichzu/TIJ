package com.pro.fanlz.multithreading.demo;

import java.util.concurrent.*;

/**
 * @author fanlz
 * @description: 创建线程的方式4：使用线程池
 * @date 2021/8/31 14:32
 */
class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPool {

    /**
     * 线程池的基本大小
     */
    static int corePoolSize = 10;
    /**
     * 线程池最大数量
     */
    static int maximumPoolSizeSize = 100;
    /**
     * 线程活动保持时间
     */
    static long keepAliveTime = 1;
    /**
     * 任务队列
     */
    static ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);

    public static void main(String[] args) {
        // 手动创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSizeSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                workQueue
        );
        // 执行线程
        threadPoolExecutor.execute(new NumberThread1());
        threadPoolExecutor.execute(new NumberThread1());
        threadPoolExecutor.execute(new NumberThread1());

        // 销毁线程
        threadPoolExecutor.shutdown();
    }
}
