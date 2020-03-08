package com.Biweekly.BiweeklyContest21;

import java.util.HashMap;
import java.util.Map;

public class Maximum_Sum_BST_in_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int ans = 0;
    Map<TreeNode,Integer> max = new HashMap<>();
    Map<TreeNode,Integer> min = new HashMap<>();
    Map<TreeNode,Integer> sum = new HashMap<>();
    public int maxSumBST(TreeNode root) {
        if(root==null)
            return 0;
        findMax(root.left);
        findMax(root.right);
        findMin(root.left);
        findMin(root.right);
        findSum(root);
        boolean leftBuildTree = ifCanBuildTree(root.left);
        boolean rightBuildTree = ifCanBuildTree(root.right);
        if(leftBuildTree&&rightBuildTree){
            if(root.left==null&&root.right==null)
                return root.val;
            if(root.left!=null){
                if(max.get(root.left)>=root.val)
                    return ans;
            }
            if(root.right!=null){
                if(min.get(root.right)<=root.val)
                    return ans;
            }
            return root.val+sum.getOrDefault(root.left,0)+sum.getOrDefault(root.right,0);
        }
        return ans;
    }

    private int findMax(TreeNode root) {
        if(root==null)
            return Integer.MIN_VALUE;
        int maxValue = Math.max(root.val,Math.max(findMax(root.left),findMax(root.right)));
        max.put(root,maxValue);
        return maxValue;
    }
    private int findMin(TreeNode root) {
        if(root==null)
            return Integer.MAX_VALUE;
        int minValue = Math.min(root.val,Math.min(findMin(root.left),findMin(root.right)));
        min.put(root,minValue);
        return minValue;
    }
    private int findSum(TreeNode root){
        if(root==null)
            return 0;
        int sumValue = root.val+findSum(root.left)+findSum(root.right);
        sum.put(root,sumValue);
        return sumValue;
    }


    private boolean ifCanBuildTree(TreeNode root) {
        if(root==null)
            return true;
        boolean leftBuildTree = ifCanBuildTree(root.left);
        boolean rightBuildTree = ifCanBuildTree(root.right);
        if(leftBuildTree&&rightBuildTree){
            if(root.left==null&&root.right==null) {
                ans = Math.max(ans,root.val);
                return true;
            }
            if(root.left!=null){
                if(max.get(root.left)>=root.val)
                    return false;
            }
            if(root.right!=null){
                if(min.get(root.right)<=root.val)
                    return false;
            }
            ans = Math.max(ans,root.val+sum.getOrDefault(root.left,0)+sum.getOrDefault(root.right,0));
            return true;
        }
        return false;
    }
}
