package com.pro.fanlz.multithreading.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanlz
 * @description: 解决线程安全问题的方式三：lock锁 --- JDK5.0新增
 * @date 2021/7/29 16:41
 */
class LockWindow implements Runnable{

    private int ticket = 100;

    private ReentrantLock reentrantLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            reentrantLock.lock();
            try{
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally {
                reentrantLock.unlock();
            }

        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        LockWindow windows = new LockWindow();
        Thread t1 = new Thread(windows);
        Thread t2 = new Thread(windows);
        Thread t3 = new Thread(windows);

        t1.start();
        t2.start();
        t3.start();
    }
}
