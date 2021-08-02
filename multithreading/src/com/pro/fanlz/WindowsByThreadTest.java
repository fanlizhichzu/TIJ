package com.pro.fanlz;

/**
 * @author fanlz
 * @description: 创建三个窗口买票，总票数为100张
 *               存在线程安全问题，待解决
 *               说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器，保证同步监视器唯一
 * @date 2021/7/27 9:11
 */

class Window extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            synchronized(Window.class){
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+": 卖票，票号为："+ticket);
                    ticket--;
                }
                else {
                    break;
                }
            }
        }
    }
}
public class WindowsByThreadTest {
    public static void main(String[] args) {
        new Window().start();
        new Window().start();

        new Window().start();
    }
}
