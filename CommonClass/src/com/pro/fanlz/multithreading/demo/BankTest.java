package com.pro.fanlz.multithreading.demo;

/**
 * @author fanlz
 * @description: 线程安全单例模式懒汉式(使用线程同步方式)
 * @date 2021/7/28 16:09
 */

class Bank{
    private Bank(){}

    private static Bank instance = null;

    public  static Bank getInstance(){
//        // 方式一：效率稍差
//        synchronized (Bank.class){
//            if (instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        // 方式二：效率更高
        if(instance == null){
            synchronized (Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
public class BankTest {
}
