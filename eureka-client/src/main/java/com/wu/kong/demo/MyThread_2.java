package com.wu.kong.demo;

/*
 * 2,实现Runnable接口，重写run方法
 * 不论创建多少个线程，只需要创建一个Runable接口实现类的对象
 * 启动线程，new Thread (Runnable 接口实现类的对象).strat()
 * 创建线程调用的是Thread类Runable类型参数的构造器
 * */
public class MyThread_2 {
    public static void main(String[] args) {
        Runnable implRunnable = new ImplRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(implRunnable).start();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class ImplRunnable implements Runnable {
    private volatile int i = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--" + i++);
    }
}