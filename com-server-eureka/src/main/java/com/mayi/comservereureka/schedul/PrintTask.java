package com.mayi.comservereureka.schedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description: 定时任务
 * @Date: Create in 14:15 2019/9/20
 */
@Component
public class PrintTask {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        System.out.println("NOW：" + sdf.format(new Date()));
    }

}
