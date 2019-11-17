package com.km.WeeklyContest163;

import javafx.util.Builder;

import java.util.HashSet;
import java.util.Set;

public class Find_Elements_in_a_Contaminated_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class FindElements {
        TreeNode newRoot=null;
        Set<Integer> set = new HashSet<>();
        public FindElements(TreeNode root) {
            if(root!=null){
                set.add(0);
                newRoot = BuildTree(root,0);
            }
        }

        private TreeNode BuildTree(TreeNode root, int num) {
            set.add(num);
            TreeNode child = new TreeNode(num);
            if(root.left!=null){
                child.left = BuildTree(root.left,num*2+1);
            }
            if(root.right!=null){
                child.right = BuildTree(root.right,num*2+2);
            }
            return child;
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
