package com.mayi.web;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 15:16 2020/8/8
 */
public class Test {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("level","0");

        Object param =  map.get("level");

        if(param instanceof Integer){
            System.out.println("123");
        }
        if(((Integer) param) .intValue() == 0){
            System.out.println("456");
        }
        if(param instanceof Integer && ((Integer) param) .intValue() == 0){
            System.out.println("789");
        }
    }
}
