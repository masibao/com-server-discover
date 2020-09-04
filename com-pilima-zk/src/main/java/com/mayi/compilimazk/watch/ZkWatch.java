package com.mayi.compilimazk.watch;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 18:00 2020/6/24
 */
@Component
public class ZkWatch {

    @Autowired
    private ZkClient zkc;

    public void watch(){

        zkc.subscribeDataChanges("/zookeeper/lock", new IZkDataListener() {
            // 得到删除节点的path
            @Override
            public void handleDataDeleted(String path) throws Exception {
                System.out.println(">>监听到删除的节点为:" + path);
            }

            // 得到变更的节点和变更的内容
            @Override
            public void handleDataChange(String path, Object data) throws Exception {
                System.out.println(">>监听到变更的节点为:" + path + ", 变更内容为:" + data);
            }

        });



    }
}
