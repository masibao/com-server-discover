package com.mayi.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 21:19 2020/1/20
 */
public class StringTest {


    public static void main(String[] args) {

        String str1="AB";
        String str3="A" + "B";
        String str2= new String("AB");
        System.out.println(str1 == str3);
        System.out.println(str1 == str2);
        System.out.println(str1 == str2.intern());
    }



}
