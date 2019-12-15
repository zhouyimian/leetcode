package com.km.WeeklyContest167;

public class Convert_Binary_Number_in_a_Linked_List_to_Integer {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head!=null&&head.val==0)
            head = head.next;
        StringBuilder sb = new StringBuilder();
        while (head!=null){
            sb.append(head.val);
            head = head.next;
        }
        for(int i = 0;i<sb.length();i++){
            ans=(ans*2)+(sb.charAt(i)=='0'?0:1);
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(0);
        Convert_Binary_Number_in_a_Linked_List_to_Integer t = new Convert_Binary_Number_in_a_Linked_List_to_Integer();
        System.out.println(t.getDecimalValue(root));

    }
}
