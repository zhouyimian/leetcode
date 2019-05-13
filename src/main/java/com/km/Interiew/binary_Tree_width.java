package com.km.Interiew;

import java.util.HashMap;
import java.util.Map;

public class binary_Tree_width {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer[]> record = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Integer[] first = {1, 1};
        record.put(1, first);
        dfs(root.left, 2, 2);
        dfs(root.right, 2, 3);
        int ans = 0;
        for (Map.Entry<Integer, Integer[]> entry : record.entrySet()) {
            Integer[] value = entry.getValue();
            ans = Math.max(ans, value[1] - value[0]+1);
        }
        return ans;
    }

    public void dfs(TreeNode node, int depth, int number) {
        if(node==null) return ;
        Integer[] value = record.get(depth);
        if (value == null) {
            value = new Integer[2];
            value[0] = number;
            value[1] = number;
        }
        else{
            value[0] = Math.min(value[0],number);
            value[1] = Math.max(value[1],number);
        }
        record.put(depth,value);
        dfs(node.left,depth+1,number*2);
        dfs(node.right,depth+1,number*2+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        binary_Tree_width test = new binary_Tree_width();
        root.left = new TreeNode(2);
        root.left.left  = new TreeNode(2);
        root.left.right = new TreeNode(3);
        System.out.println(test.widthOfBinaryTree(root));

    }
}
