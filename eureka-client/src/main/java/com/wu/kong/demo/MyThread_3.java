package com.wu.kong.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/*
 * 3,实现Callable接口，重写call方法（有返回值）
 * 自定义类实现Callable接口时，必须指定泛型，该泛型即返回值的类型
 * 每次创建一个新的线程，都要创建一个新的Callable接口的实现类
 * 如何启动线程？
 * （1）创建一个Callable接口的实现类对象
 * （2）创建一个FutureTask对象，传入Callable类型的参数
 * public FutureTask(Callable<V0 callable{...}>)
 * (3)调用Thread类重载的参数为Runnable的构造器创建Thread对象
 * 将Future Task作为参数传递
 * public class FutureTask<V>implements Runnable Future<V>
 * 如何获取返回值？
 * 调用FutureTask类的get（）方法
 * */
public class MyThread_3 {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Callable<Integer> implCallable = new ImplCallable();
            FutureTask<Integer> futureTask = new FutureTask<Integer>(implCallable);
            new Thread(futureTask).start();
            System.out.println(Thread.currentThread().getName() + "---" + futureTask.get());
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class ImplCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += 1;
        }
        System.out.println(Thread.currentThread().getName());
        return result;
    }
}