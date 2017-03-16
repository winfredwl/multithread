package com.winfred.study.main;

import com.winfred.study.callable.TestCallable;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class FutureTaskMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * 采用Thread
         */
//        System.out.println("主线程开始于:" + LocalTime.now());
//        TestCallable taskA = new TestCallable("A", 1, 200);
//        TestCallable taskB = new TestCallable("B", 2, 1000);
//        TestCallable taskC = new TestCallable("C", 3, 1);
//        FutureTask<Integer> resultA = new FutureTask<>(taskA);
//        FutureTask<Integer> resultB = new FutureTask<>(taskB);
//        FutureTask<Integer> resultC = new FutureTask<>(taskC);
//        new Thread(resultA).start();
//        new Thread(resultB).start();
//        new Thread(resultC).start();
//
//        System.out.println("taskA运行结果:" + resultA.get());
//        System.out.println("taskB运行结果:" + resultB.get());
//        System.out.println("taskC运行结果:" + resultC.get());
//
//        System.out.println("主线程结束于:" + LocalTime.now());

        /**
         * 采用线程池
         */
        System.out.println("主线程开始于:" + LocalTime.now());
        TestCallable task1 = new TestCallable("A", 1, 200);
        TestCallable task2 = new TestCallable("B", 2, 1000);
        TestCallable task3 = new TestCallable("C", 3, 1);
        FutureTask<Integer> result1 = new FutureTask<>(task1);
        FutureTask<Integer> result2 = new FutureTask<>(task2);
        FutureTask<Integer> result3 = new FutureTask<>(task3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(result1);
        executorService.execute(result2);
        executorService.execute(result3);
        executorService.shutdown();

        System.out.println("taskA运行结果:" + result1.get());
        System.out.println("taskB运行结果:" + result2.get());
        System.out.println("taskC运行结果:" + result3.get());

        System.out.println("主线程结束于:" + LocalTime.now());
    }
}
