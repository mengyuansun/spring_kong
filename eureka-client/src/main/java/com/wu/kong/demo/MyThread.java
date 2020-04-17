package com.wu.kong.demo;

/*1,继承Thread类，重写run方法
 * 每次创建一个新的线程，都要新建一个Thread子类的对象
 * 启动线程，new Thread 子类（）.start()
 * 创建线程实际调用的是父类Thread空参的构造器
 * */
public class MyThread {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ExtendsThread().start();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class ExtendsThread extends Thread {
    @Override //重写run方法
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}