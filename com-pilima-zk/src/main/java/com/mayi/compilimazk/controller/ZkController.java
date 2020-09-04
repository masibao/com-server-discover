package com.mayi.compilimazk.controller;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 17:43 2020/6/24
 */
@RestController
@RequestMapping("/")
public class ZkController {

    @Autowired
    private ZkClient zkClient;


    @GetMapping("/dataChange")
    public String dataChange(@RequestParam("node") String node) throws InterruptedException {

        String path = node + "/port";
        if(!zkClient.exists(node)){
            zkClient.createPersistent(node);
        }

        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("handleDataChange==path:" + s + "  data:" + o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

                System.out.println("handleDataDeleted==s  "+ s);
            }
        });
        System.out.println("**************************************************************");

        zkClient.createPersistent(path);
        sleep10s();
        zkClient.writeData(path,1);
        sleep10s();
        zkClient.writeData(path,5);
        sleep10s();
        zkClient.delete(path);
        sleep10s();
        zkClient.unsubscribeAll();
        zkClient.close();

        return "ok";
    }

    private void sleep10s(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * http://localhost:7077/createNode?node=/zookeeper/lock
     * @param node
     * @return
     */
    @GetMapping("/createNode")
    public String registerNode(@RequestParam("node") String node) throws InterruptedException {

        zkClient.createPersistent(node,"nishigedashibi");

        sub(node);


        Thread.sleep(3000);
        zkClient.writeData(node, "321", -1);
        Map.Entry<List<ACL>, Stat> acl = zkClient.getAcl(node);
        Thread.sleep(1000);

        zkClient.delete(node);
        Map.Entry<List<ACL>, Stat> acl2 = zkClient.getAcl(node);
        Thread.sleep(Integer.MAX_VALUE);

        return "ok";
    }

    private void sub(String path){
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("handleDataChange>>>>>" + s);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("handleDataDeleted>>>>>" + s);
            }
        });
    }
}
