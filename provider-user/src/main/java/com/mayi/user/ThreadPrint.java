package com.mayi.user;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 11:56 2020/1/21
 */
public class ThreadPrint {

    private static int count = 1;
    private static final Object lock = new Object();


    public static void main(String[] args) {
        try {
            turning();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void turning() throws InterruptedException {
        new Thread(new TurningRunner(), "奇数").start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        new Thread(new TurningRunner(), "偶数").start();


    }

    static class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                // 获取锁
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    // 唤醒其他线程
                    lock.notifyAll();
                    try {
                        if (count <= 100) {
                            // 如果任务还没有结束，则让出当前的锁并休眠
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
