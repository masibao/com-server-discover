package com.mayi.user.leetcode;


/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 14:39 2020/5/29
 *
 *
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
 *
 *
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        ListNode head = new ListNode(0);
        ListNode cursPos = head;
        int carry = 0;//定义一个进位数值
        while (l1 != null || l2 != null || carry != 0){
            int val1 = l1 == null ? 0:l1.val;
            int val2 = l2 == null ? 0:l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum%10);
            cursPos.next = newNode;
            cursPos = cursPos.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return head.next;

    }

       public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
          }

          public static String print(ListNode l){
              StringBuffer sb = new StringBuffer();
              while (l != null){
                  sb.append(l.val);
                  l = l.next;
              }
              return sb.toString();
          }
      }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);

        l1.next = new ListNode(4);
        l2.next = new ListNode(6);

        l1.next.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(ListNode.print(addTwoNumbers(l1,l2)));
    }
}
