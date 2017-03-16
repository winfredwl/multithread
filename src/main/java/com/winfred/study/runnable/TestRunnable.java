package com.winfred.study.runnable;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class TestRunnable implements Runnable {

    private String name;
    private long delayTime;

    public TestRunnable(String name, long delayTime) {
        this.name = name;
        this.delayTime = delayTime;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(delayTime);
                System.out.println("线程" + name + ": " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
