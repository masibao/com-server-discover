package com.mayi.user.util;

import java.util.Objects;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 21:33 2020/2/5
 */
public class ListNode {
    public ListNode next;
    public ListNode pre;

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }
}
