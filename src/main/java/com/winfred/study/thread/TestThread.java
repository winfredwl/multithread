package com.winfred.study.thread;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class TestThread extends Thread {
    private String name;
    private long delayTime;

    public TestThread(String name, long delayTime) {
        this.name = name;
        this.delayTime = delayTime;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(delayTime);
                System.out.println("线程" + name + ": " + i + " ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
