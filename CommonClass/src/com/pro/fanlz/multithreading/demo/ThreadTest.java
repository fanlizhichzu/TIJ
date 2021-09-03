package com.pro.fanlz.multithreading.demo;

/**
 * @author fanlz
 * @description: 遍历100以内的所有的偶数
 * 多线程的创建，方式一：继承于Thread类
 * 1、创建一个继承于thread类的子类
 * 2、重写Thread类的run()
 * 3、创建Thread类的子类的对象
 * 4、通过此对象调用start()
 * @date 2021/7/22 15:51
 */
// 1、创建一个继承于thread类的子类
class MyThreads extends Thread {

    //2、重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : "+ getPriority() +"    "+ + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        // 3、创建Thread类的子类的对象
        MyThreads threads = new MyThreads();

        threads.setPriority(Thread.MAX_PRIORITY);
        // 4、通过此对象调用start()
        // start()：启动当前线程
        // 调用当前线程的run()
        threads.start();

        MyThreads threads1 = new MyThreads();

        threads1.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " : " + "   " + i);
                    }
                }
            }
        }.start();

        System.out.println(Thread.currentThread().getPriority());

    }
}


