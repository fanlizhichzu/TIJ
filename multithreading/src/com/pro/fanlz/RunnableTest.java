package com.pro.fanlz;

/**
 * @author fanlz
 * @description: 创建多线程的方式二：实现Runnable
 * @date 2021/7/27 9:40
 */
//1.创建一个实现Runnable接口的类
class MyThread implements Runnable{

    //2.实现类去实现Runnable中的抽象方法：Run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
public class RunnableTest {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MyThread myThread = new MyThread();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t = new Thread(myThread);
        //5.通过thread类的对象调用start():①启动线程 ②调用当前线程的run()-->调用了Runnable类型的target
        t.start();
    }
}
