package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Next_Greater_Node_In_Linked_List {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null)
            return new int[0];
        else if(head.next==null){
            int[] nums = {0};
            return nums;
        }
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<list.size();i++){
            if(stack.isEmpty()||list.get(stack.peek())>=list.get(i)){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&list.get(stack.peek())<list.get(i)){
                    res[stack.pop()] = list.get(i);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}
