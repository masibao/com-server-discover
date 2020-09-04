//package com.mayi.user;
//
///**
// * @Classname com-server-discover
// * @Author: Tony
// * @Description:
// * @Date: Create in 17:56 2020/1/21
// */
//
//public class Solution {
//    public static void main(String[] args) {
//        System.out.println(numSum("AB-1CD--2EF---3"));
//    }
//
//    /*
//    * 作者：Storm201808030946924
//链接：https://www.nowcoder.com/discuss/100519?order=0&page=0&pos=23&type=0
//来源：牛客网
//
//var line = readline();
//var pattern = /\-*\d+/g;
//var nums = line.match(pattern);
//var notNull = pattern.test(line);
//var result = 0;
//var length;
//if(notNull){
//    length = nums.length;
//}
//else{
//    length = 0;
//}
//for(let i=0;i<length;i++){
//    let j = 0;
//    let count = 0;
//    while(nums[i][j]=="-"){
//        count++;
//        j++;
//    }
//    if(count % 2 == 0){
//        nums[i] = nums[i].match(/\d+/);
//    }
//    else{
//        nums[i] = "-" + nums[i].match(/\d+/);
//    }
//    result += parseInt(nums[i]);
//}
//console.log(result);
//    *
//    *
//    * */
//
//    public static int numSum(String str) {
//        if (str == null) {
//            return 0;
//        }
//
//
//        String patern = "/-*d+/g";
//
//        return 1;
//    }
//    /*public static int numSum(String str) {
//        if (str == null) {
//            return 0;
//        }
//        int res = 0;
//        int num = 0;
//        int cur = 0;
//        boolean isPos = true;
//        char[] ch = str.toCharArray();
//        for (int i = 0; i < ch.length; i++) {
//            cur = ch[i] - '0';
//            if (cur < 0 || cur > 9) {
//                res += num;
//                num = 0;
//                if (ch[i] == '-') {
//                    if (i - 1 > -1 && ch[i - 1] == '-') {
//                        isPos = !isPos;
//                    } else {
//                        isPos = false;
//                    }
//                } else {
//                    isPos = true;
//                }
//            } else {
//                num = num * 10 + (isPos ? cur : -cur);
//            }
//        }
//        res += num;
//        return res;
//    }*/
//
//
//
//
//
//}


/*--------------------------------------------------------------*/
import com.mayi.user.util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
/**
 *给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 输入:
 * [
 *  *  [ 1, 2, 3 ,4],
 *  *  [ 5, 6 ,7,8],
 *  *  [ 9,10,11,12],
 *     [13,14,15,16]
 *  * ]
 *
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 时间空间复杂度为o(n)
 */
/*
public class Solution {
    public static List< Integer > spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);//1
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] arrs = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(arrs));;
    }
}*/


/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(90);
    }
}

