package com.mayi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 10:30 2020/6/4
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String params = "ddcf";
        solution(params);
//        lengthOfLongestSubstring1(params);


        String name = "马克花呗";
        String idx = "花呗";
        int i = name.indexOf(idx);
        String new1 = name.replace(idx,"哈哈");
        System.out.println(new1);
        /*char[] chars = params.toCharArray();
        HashSet strings = new HashSet();
        for (char item:chars) {
            strings.add(item);
        }*/

        /*strings.add("d");
        strings.add("c");
        strings.add("b");
        strings.add("a");
        strings.add("e");
        strings.add("g");*/
    }

/*    public static void solution(String params){
        HashSet strings = new HashSet();

        char[] chars = params.toCharArray();
        int maxLen = 0;
        for (char item:chars) {
            if(strings.contains(item)){
                if(strings.size() > maxLen)
                    maxLen = strings.size();
                strings.clear();
            }
            strings.add(item);
        }
        if(strings.size() > maxLen)
            maxLen = strings.size();
        System.out.println("最大长度为:"+ maxLen);
    }*/



    public static int solution(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int len = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < len; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < len && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        System.out.println(ans);
        return ans;
    }

}
