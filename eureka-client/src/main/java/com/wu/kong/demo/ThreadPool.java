package com.wu.kong.demo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 线程池
 * 跟数据库连接池类似
 * 避免了线程的创建和销毁造成的额外开销
 * java.util.connection
 *
 * Executor   负责线程的使用和调度的跟接口
 *   |--ExcutorServer   线程池的主要接口
 *      |--ThreadPoolExecutor   线程池的实现类
 *      |--ScheduledExecutorService   接口，负责线程的调度
 *          |--ScheduledThreadPoolExecutor   (extends ThreadPoolExecutor implements ScheduledExecutorService)
 *
 * Executors工具类
 * 提供了创建线程池的方法
 *
 * */
public class ThreadPool {
    public static void main(String[] args) {
        //使用Executors 工具类中的方法创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        ThreadPoolDemo demo = new ThreadPoolDemo();
        //为线程池中的线程分配任务，使用submit方法，传入的参数可以是Runnable的实现类，也可以时Callable
        //的实现类
        for (int i = 0; i <= 5; i++) {
            pool.submit(demo);
        }
        //关闭线程池
        //shuntdown ：以一种平和的方式关闭线程池，在关闭线程池之前，会等待线程池中的
        //所有任务结束，不在接受新任务
        //shuntdoenNow : 立即关闭线程池
        pool.shutdown();
    }
}

class ThreadPoolDemo implements Runnable {
    //多线程的共享数据
    private int i = 0;

    @Override
    public void run() {
        while (i <= 50) {
            System.out.println(Thread.currentThread().getName() + "--" + i++);
        }
    }
}