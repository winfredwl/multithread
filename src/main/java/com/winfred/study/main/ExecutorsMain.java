package com.winfred.study.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class ExecutorsMain {

    public static void main(String[] args) {
        /**
         * 固定长度的线程池，每当提交一个任务时就创建一个线程，当到达线程最大数量时，线程池的规模将不再变化（如果
         * 某个线程由于发生了未预期的Exception而结束，那么线程池会补充一个新线程）。
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int n = i;
            fixedThreadPool.execute(() -> {
                try {
                    System.out.print(n + "  ");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        fixedThreadPool.shutdown();

        /**
         * 可缓存的线程池，如果当前线程池的规模超出了处理需求，将回收空闲的线程；当需求增加时，会增加新的线程；线程池规模无限制。
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int n = i;
            cachedThreadPool.execute(() -> {
                try {
                    System.out.print(n + " ");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        cachedThreadPool.shutdown();

        /**
         * 单线程的Executor，如果这个线程异常结束，会创建另一个线程来替代。newSingleThreadExecutor能确保依照任务在队列中的顺序来串行执行。
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int n = i;
            singleThreadExecutor.execute(() -> {
                try {
                    System.out.print(n + "   ");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        singleThreadExecutor.shutdown();

        /**
         * 单线程延时线程池
         */
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        singleThreadScheduledExecutor.schedule(() -> System.out.print("延时5秒"), 5, TimeUnit.SECONDS);
        singleThreadScheduledExecutor.shutdown();

        /**
         * 固定长度的线程池，而且以延迟或者定时的方式来执行
         */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("延时5秒执行1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
        scheduledThreadPool.schedule(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("延时5秒执行2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
        scheduledThreadPool.schedule(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("延时5秒执行3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
        scheduledThreadPool.schedule(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("延时5秒执行4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
        scheduledThreadPool.schedule(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("延时5秒执行5");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
        scheduledThreadPool.schedule(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("延时5秒执行6");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();

        ScheduledExecutorService scheduledThreadPoolAtFixedRate = Executors.newScheduledThreadPool(3);
        scheduledThreadPoolAtFixedRate.scheduleAtFixedRate(() -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println("延时5秒后每隔1秒执行一次");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, 5, 1, TimeUnit.SECONDS
        );
    }
}
