package com.pro.fanlz.multithreading;

/**
 * @author fanlz
 * @description: 创建三个窗口卖票，总票数为100张，使用实现runnable接口的方式
 * @date 2021/7/27 10:17
 */
class Windows implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class WindowsByRunnable {
    public static void main(String[] args) {
        Windows windows = new Windows();
        Thread t1 = new Thread(windows);
        Thread t2 = new Thread(windows);
        Thread t3 = new Thread(windows);

        t1.start();
        t2.start();
        t3.start();
    }
}
