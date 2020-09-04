package com.eureka.server2;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 11:05 2020/6/10
 */
public class Test {

    public static void main(String[] args) {

        String[] arrayA = new String[] { "1", "2", "3", "3","3", "4", "5" };
        String[] arrayB = new String[] { "3", "4", "4", "5", "6","3", "7" ,"3" , "3" };
        List<String> a = Arrays.asList(arrayA);
        List<String> b = Arrays.asList(arrayB);
        Collection<String> intersection = CollectionUtils.intersection(a, b);

        Set set = new HashSet<String>(intersection);
        System.out.println( ArrayUtils.toString(set.toArray()));



    }
}
