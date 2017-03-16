package com.winfred.study.callable;

import java.util.concurrent.Callable;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class TestCallable implements Callable<Integer> {
    private String name;
    private int num;
    private int delayTime;

    public TestCallable(String name, int num, int delayTime) {
        this.name = name;
        this.num = num;
        this.delayTime = delayTime;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("task" + name + "开始运行");
        Thread.sleep(delayTime);
        return num;
    }
}
