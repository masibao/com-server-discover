package com.mayi.leetcode;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 11:14 2020/6/2
 */
@Component
public class LifeCircle {


    public LifeCircle(){
        System.out.println("=====1====");
    }

    static {
        System.out.println("=====2=====");
    }

    @PostConstruct
    public void init(){
        System.out.println("=====3====");
    }

}
