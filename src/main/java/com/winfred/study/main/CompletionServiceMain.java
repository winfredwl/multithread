package com.winfred.study.main;

import com.winfred.study.callable.TestCallable;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class CompletionServiceMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("主线程开始于:" + LocalTime.now());
        TestCallable task1 = new TestCallable("A", 1, 200);
        TestCallable task2 = new TestCallable("B", 2, 1000);
        TestCallable task3 = new TestCallable("C", 3, 1);

        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
        completionService.submit(task1);
        completionService.submit(task2);
        completionService.submit(task3);

        System.out.println("运行结果:" + completionService.take().get());
        System.out.println("运行结果:" + completionService.take().get());
        System.out.println("运行结果:" + completionService.take().get());

        System.out.println("主线程结束于:" + LocalTime.now());
    }
}
