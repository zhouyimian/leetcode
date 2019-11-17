package com.km;


import java.util.*;

public class Main {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int count = 0;
    int max = 0;
    public boolean isCompleteTree(TreeNode root) {
        PriorityQueue queue = new PriorityQueue();
        if(root==null)
            return true;
        count = 1;
        max = 1;
        dfs(root.left,2);
        dfs(root.right,3);
        return count==max;
    }
    public void dfs(TreeNode root,int cur){
        if(root==null)
            return;
        count++;
        max = Math.max(max,cur);
        dfs(root.left,cur*2);
        dfs(root.right,cur*2+1);
    }
}
