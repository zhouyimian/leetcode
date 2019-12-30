package com.km.WeeklyContest169;

import java.util.*;

public class All_Elements_in_Two_Binary_Search_Trees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        visit(root1,ans);
        visit(root2,ans);

        Collections.sort(ans);
        return ans;
    }
    public void visit(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        visit(root.left,list);
        visit(root.right,list);
    }

    public static void main(String[] args) {
        All_Elements_in_Two_Binary_Search_Trees test = new All_Elements_in_Two_Binary_Search_Trees();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        List<Integer> list = test.getAllElements(root1,root2);
        for(int num:list)
            System.out.println(num);
    }
}
