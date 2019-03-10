package com.km.leetcode;

import java.math.BigInteger;

public class Add_Two_Numbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        while (l1 != null) {
            sb1.append(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            sb2.append(l2.val);
            l2=l2.next;
        }
        sb1 = sb1.reverse();
        sb2 = sb2.reverse();
        BigInteger b1 = new BigInteger(sb1.toString());
        BigInteger b2 = new BigInteger(sb2.toString());
        BigInteger ans = b1.add(b2);
        StringBuilder sb = new StringBuilder(ans.toString());
        sb = sb.reverse();
        ListNode ansNode = new ListNode(sb.charAt(0)-'0');
        ListNode temp = ansNode;
        for(int i = 1;i<sb.length();i++){
            ListNode next = new ListNode(sb.charAt(i)-'0');
            temp.next = next;
            temp=temp.next;
        }
        return ansNode;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(2);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(3);

        ListNode root2 = new ListNode(5);
        root2.next = new ListNode(6);
        root2.next.next = new ListNode(4);
        Add_Two_Numbers test =new Add_Two_Numbers();
        ListNode ans = test.addTwoNumbers(root1,root2);
        while(ans!=null){
            System.out.println(ans.val);
            ans=ans.next;
        }

    }
}
