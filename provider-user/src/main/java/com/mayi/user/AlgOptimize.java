package com.mayi.user;



import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author: Neo M
 * @Desc: 算法优化
 * @Date: Create in 13:41 2020/5/28
 */
public class AlgOptimize {

    public static void main(String[] args) {

        /*Function<Integer,Integer> A= i->i+1;
        Function<Integer,Integer> B=i->i*i;
        System.out.println("F1:"+B.apply(A.apply(5)));
        System.out.println("F2:"+A.apply(B.apply(5)));*/

//        Map<Integer,Function<Integer,action>> args = new HashMap<>();
        int max = Math.max(55, 25);
        System.out.println(max);
        int min = Math.min(20, 60);
        System.out.println(min);



        /**
         * actionMappings：使用表驱动来减少if else的使用 提高代码的可读性
         * Function<T,R> T为参数 R为返回值 定义R为1调用成功 为0调用失败
         * */
        /*Map<String, Function<String,Integer>> actionMappings = new HashMap<>(16);
        List<String> resultList = Lists.newArrayList();
        // 初始化indexType表驱动
        actionMappings.put("LIVE_USER", (params)->{
            System.out.println("调用该函数{}" + params);
            resultList.add(params);
            return 10;
        });*/
        /*actionMappings.put("STABLE_USER", indexTypeStableUser);
        actionMappings.put("WORK_USER", indexTypeWorkUser);
        actionMappings.put("LONG_LIVE_USER", indexTypeLongLiveUser);
        actionMappings.put("LONG_WORK_USER", indexTypeLongWorkUser);*/

        // 调用
        /*Integer apply = actionMappings.get("LIVE_USER").apply("param");
        System.out.println("------>"+ resultList.toString());
        System.out.println("------>status"+ apply);*/



        Map<Integer, Function<Integer,Integer>> actionMappings = new HashMap<>(16);
        List<Integer> resultList = Lists.newArrayList();

        init(actionMappings,resultList);
        Integer apply = actionMappings.get(1).apply(222);
        Integer apply2 = actionMappings.get(2).apply(222);
        Integer apply3 = actionMappings.get(3).apply(222);

        System.out.println(apply);
        System.out.println(apply2);
        System.out.println(apply3);

        System.out.println("-------------");
        System.out.println(resultList.toString());

    }

    private static void init(Map<Integer, Function<Integer, Integer>> actionMappings, List<Integer> resultList){

        // 初始化indexType表驱动
        actionMappings.put(1, (params)->{
            System.out.println("调用该函数1{}" + params);
            params =1011;
            resultList.add(params);
            return 11;
        });

        actionMappings.put(2, (params)->{
            System.out.println("调用该函数2{}" + params);
            params =1022;
            resultList.add(params);
            return 12;
        });

        actionMappings.put(3, (params)->{
            System.out.println("调用该函数3{}" + params);
            params =1033;
            resultList.add(params);
            return 13;
        });
    }





}
