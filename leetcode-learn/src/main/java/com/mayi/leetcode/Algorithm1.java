package com.mayi.leetcode;

/**
 *
 *求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Algorithm1 {

    public static void main(String[] args) {
        int num = 3;
        System.out.println(sumNums(num));
    }
    public static int sumNums(int n) {

        boolean flag = n>0 && (n+= sumNums(n - 1)) > 0;
        return n;
    }

    //3+sumNums(2) + 3
    //2 + sumNums(1) 1
    //1 + sumNums(0) 0
}
