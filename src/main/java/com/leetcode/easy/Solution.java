package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lornezhang on 2019/1/9.
 */
public class Solution {

    /**
     * Definition for Singly-linked list
     */
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     *
     * @param prev = null
     * @param curr = node1
     * @return
     */
    public ListNode reverseList2(ListNode prev, ListNode curr) {
        if(curr == null )  {
            return prev;
        }
        ListNode head = reverseList2(curr, curr.next);
        curr.next = prev;
        return head;
    }

    /**
     * return node5
     * node5.next --> 4
     *
     *
     *
     * 1 --> 2 --> 3 --> 4 --> 5 --> null
     * 5 --> 4
     *
     *
     *
     *
     * 5= 4 return node5
     * 4 = 3
     * 3 = 2
     * 2 = 1
     * 1= null
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> reserveList(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null) {
            arrayList.addAll(reserveList(listNode.next));
            arrayList.add(listNode.val);
        }
        return arrayList;
    }



    /**
     * 从尾到头打印链表
     *
     * 1. 使用栈
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        ArrayList<Integer> arrayList = new Solution().printListFromTailToHead(node1);
//        for (Integer i : arrayList) {
//            System.out.println(i);
//        }
//        new Solution().reverseList2(null, node1);
         new Solution().reserveList(node1);
    }
}
