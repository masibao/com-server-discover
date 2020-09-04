package com.mayi.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 21:19 2020/1/20
 */
public class StringFind {


    public static void main(String[] args) {

        String str1="hello";
        String str2="llo";
        System.out.println(panduan(str1,str2));
    }


    public static int panduan(String str1,String regx){
        Pattern compile = Pattern.compile(regx);
        Matcher matcher = compile.matcher(str1);
        if(matcher.find()){
            return matcher.start();
        }
        return -1;
    }

}
