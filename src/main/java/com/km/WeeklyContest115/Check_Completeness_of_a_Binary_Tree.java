package com.km.WeeklyContest115;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Check_Completeness_of_a_Binary_Tree {
    public boolean isCompleteTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return true;
        if(root.left==null&&root.right!=null)
            return false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        while((temp=queue.poll())!=null){
            queue.add(temp.left);
            queue.add(temp.right);
        }
        while(!queue.isEmpty()){
            if(queue.poll()!=null)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(6);
        Check_Completeness_of_a_Binary_Tree test=new Check_Completeness_of_a_Binary_Tree();
        System.out.println(test.isCompleteTree(node));
    }
}
