package com.km.WeeklyContest180;

import java.util.ArrayList;
import java.util.List;

public class Balance_a_Binary_Search_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addNums(root,list);
        TreeNode newRoot = new TreeNode(list.get(list.size()/2));
        newRoot.left = buildTree(list.subList(0,list.size()/2));
        newRoot.right = buildTree(list.subList(list.size()/2+1,list.size()));
        return newRoot;
    }

    private TreeNode buildTree(List<Integer> list) {
        if(list.size()==0)
            return null;
        if(list.size()==1)
            return new TreeNode(list.get(0));
        TreeNode root = new TreeNode(list.get(list.size()/2));
        root.left = buildTree(list.subList(0,list.size()/2));
        root.right = buildTree(list.subList(list.size()/2+1,list.size()));
        return root;
    }

    private void addNums(TreeNode root, List<Integer> list) {
        if(root==null)
            return;
        addNums(root.left,list);
        list.add(root.val);
        addNums(root.right,list);
    }

    public static void main(String[] args) {
        Balance_a_Binary_Search_Tree test = new Balance_a_Binary_Search_Tree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        TreeNode ans = test.balanceBST(root);
    }
}
