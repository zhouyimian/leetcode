package com.km.WeeklyContest122;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Vertical_Order_Traversal_of_a_Binary_Tree {
    List<List<ArrayList<Integer>>> tempans = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int min = 0;
    int max = 0;
    int length=0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        if(root.left!=null)
            search(root.left,-1);
        if(root.right!=null)
            search(root.right,1);
        length = leng(root);
        for(int i=0;i<=Math.abs(min)+max;i++) {
            tempans.add(new ArrayList<>());
            for(int j=0;j<length;j++)
                tempans.get(i).add(new ArrayList<>());
        }
        addpoint(root,0,0);
        for(int i=0;i<=Math.abs(min)+max;i++) {
            List<Integer> anslist = new ArrayList<>();
            for(int j=0;j<length;j++){
                List<Integer> list = tempans.get(i).get(j);
                if(list==null)
                    continue;
                else if(list.size()==1)
                    anslist.add(list.get(0));
                else{
                    Collections.sort(list);
                    anslist.addAll(list);
                }
            }
            List<Integer> s = new ArrayList<>(anslist);
            ans.add(s);
        }
        return ans;
    }
    public int leng(TreeNode node){
        if(node==null)
            return 1;
        else
            return Math.max(leng(node.left),leng(node.right))+1;
    }
    public void addpoint(TreeNode node,int x,int y){
        List<Integer> temp = tempans.get(y+Math.abs(min)).get(x);
        if(temp==null)
            temp=new ArrayList<>();
        temp.add(node.val);
        if(node.left!=null)
            addpoint(node.left,x+1,y-1);
        if(node.right!=null)
            addpoint(node.right,x+1,y+1);
    }
    public void search(TreeNode node,int pos){
        if(pos<=min)
            min=pos;
        if(pos>=max)
            max=pos;
        if(node.left!=null)
            search(node.left,pos-1);
        if(node.right!=null)
            search(node.right,pos+1);
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        Vertical_Order_Traversal_of_a_Binary_Tree test = new Vertical_Order_Traversal_of_a_Binary_Tree();
        System.out.println(test.verticalTraversal(root));
    }
}
