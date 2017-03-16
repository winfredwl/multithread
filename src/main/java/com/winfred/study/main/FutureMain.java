package com.winfred.study.main;

import com.winfred.study.callable.TestCallable;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class FutureMain {

    public static void main(String[] args) throws InterruptedException,ExecutionException{
        System.out.println("主线程开始于:" + LocalTime.now());
        ExecutorService executorService = Executors.newCachedThreadPool();
        TestCallable taskA = new TestCallable("A", 1, 200);
        TestCallable taskB = new TestCallable("B", 2, 1000);
        TestCallable taskC = new TestCallable("C", 3, 1);
        Future<Integer> resultA = executorService.submit(taskA);
        Future<Integer> resultB = executorService.submit(taskB);
        Future<Integer> resultC = executorService.submit(taskC);

        System.out.println("taskA运行结果:" + resultA.get());
        System.out.println("taskB运行结果:" + resultB.get());
        System.out.println("taskC运行结果:" + resultC.get());

        System.out.println("主线程结束于:" + LocalTime.now());
    }
}
