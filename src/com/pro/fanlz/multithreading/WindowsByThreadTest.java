package com.pro.fanlz.multithreading;

/**
 * @author fanlz
 * @description: 创建三个窗口买票，总票数为100张
 *               存在线程安全问题，待解决
 * @date 2021/7/27 9:11
 */

class Window extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if(ticket>0){
                System.out.println(getName()+": 卖票，票号为："+ticket);
                ticket--;
            }
            else {
                break;
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
