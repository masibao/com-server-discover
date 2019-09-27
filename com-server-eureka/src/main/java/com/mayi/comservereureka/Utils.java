package com.mayi.comservereureka;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 17:23 2019/9/20
 */
public class Utils {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
