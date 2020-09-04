package com.mayi.user;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 19:02 2020/2/11
 */
public class Lock {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(false);
        CountDownLatch latch = new CountDownLatch(6);
        latch.countDown();

        ExecutorService ser = Executors.newFixedThreadPool(3);



        lock.lock();
        for(;;){

        }

    }
}
