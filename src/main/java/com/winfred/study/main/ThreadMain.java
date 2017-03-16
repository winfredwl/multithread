package com.winfred.study.main;

import com.winfred.study.thread.TestThread;


/**
 * @author Winfred
 * @since 2017/3/16
 */
public class ThreadMain {

    public static void main(String[] args) {
        TestThread threadA = new TestThread("A", 10);
        TestThread threadB = new TestThread("B", 10);

        threadA.start();
        threadB.start();
    }
}
