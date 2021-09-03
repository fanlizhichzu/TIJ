package com.pro.fanlz.multithreading.exec;

/**
 * @author fanlz
 * @description: 线程通信应用
 *
 * 生产者/消费者问题
 * 生产者(Production)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如：20),如果生产者试图生产更多的产品，店员会让生产者停一下，
 * 如果店内有空位放置产品再通知生产者继续生产，如果店内没有产品了，店员会告诉消费者等一下，
 * 如果店中有产品了再通知消费者来取走产品
 * 这里可能会出现两个问题：
 * 1、生产者比消费者快时，消费者会漏掉一些数据没有收到
 * 2、消费者比生产者快时，消费者会收取相同的数据
 * 分析：
 * 1、是否是多线程问题？是，生产线程，消费线程
 * 2、是否有共享数据？是，产品（或店员）
 * 3、如何解决线程的安全问题？同步机制 三种方法
 * 4、是否涉及线程的通信？ 是
 *
 * @date 2021/8/4 11:03
 */

class Clerk{

    private int productCount = 0;

    // 生产产品
    public synchronized void produceProduct() throws InterruptedException {
        if (productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            notify();
        }else {
             wait();
        }
    }

    // 消费产品
    public synchronized void consumeProduct() throws InterruptedException {
        if (productCount>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            productCount--;

            notify();
        }else {
             wait();
        }
    }
}

class Producter extends Thread{
    private Clerk clerk;

    public Producter(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"：开始生产产品。。。");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.produceProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"：开始消费产品。。。");
        while (true){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.consumeProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producter p1 = new Producter(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");

        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者2");

        Consumer c3 = new Consumer(clerk);
        c3.setName("消费者3");

        p1.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
