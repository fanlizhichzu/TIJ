package com.pro.fanlz;

/**
 * @author fanlz
 * @description: 创建三个窗口卖票，总票数为100张，使用实现runnable接口的方式
 * 1.问题：卖票的过程中，出现了重票、错票-->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来。
 *   直到线程a操作完成ticket时，线程才可以可以操作ticket，这种情况即使线程a出现了阻塞，也不能被改变
 * 4.在Java中，通过同步机制，来解决线程安全问题
 * 5.同步的方式，解决了线程的安全问题 --好处
 *   操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低 --局限性
 *
 * 方式一：同步代码块
 *
 * synchronized(同步监视器){
 *     // 需要被同步的代码
 *
 * }
 * 说明：1.操作共享数据的代码，即为需要被同步的代码
 *      2.共享数据：多个线程共同操作的变量。比如：ticket
 *      3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁
 *      要求：多个线程必须公用一把锁
 *
 * 方式二：同步方法
 *       如果操作共享数据的代码完整声明在一个方法中，我们不妨将此方法声明同步的
 *       1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
 *       2.非静态的同步方法，同步监视器是：this
 *       静态的同步方法，同步监视器是：当前类本身
 * @date 2021/7/27 10:17
 */
class Windows implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized(this){
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
            }
        }
    }
}

class Windows1 implements Runnable{

    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            show();
        }
    }

    // 同步监视器：windows1.class
    private static synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowsByRunnable {
    public static void main(String[] args) {
        Windows1 windows = new Windows1();
        Thread t1 = new Thread(windows);
        Thread t2 = new Thread(windows);
        Thread t3 = new Thread(windows);

        t1.start();
        t2.start();
        t3.start();
    }
}
