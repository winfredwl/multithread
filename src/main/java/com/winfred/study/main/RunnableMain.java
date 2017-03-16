package com.winfred.study.main;

import com.winfred.study.runnable.TestRunnable;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class RunnableMain {

    public static void main(String[] args) {
        TestRunnable testRunnableA = new TestRunnable("A", 10);
        TestRunnable testRunnableB = new TestRunnable("B", 10);

        Thread threadA = new Thread(testRunnableA);
        Thread threadB = new Thread(testRunnableB);
        threadA.start();
        threadB.start();
    }
}
