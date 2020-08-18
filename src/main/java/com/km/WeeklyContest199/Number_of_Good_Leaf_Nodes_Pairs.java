package com.km.WeeklyContest199;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Number_of_Good_Leaf_Nodes_Pairs {
    Map<Integer,Map<Integer,Integer>> leftMap = new HashMap<>();
    Map<Integer,Map<Integer,Integer>> rightMap = new HashMap<>();
    public int countPairs(TreeNode root, int distance) {
        if(root==null)
            return 0;
        if(root.left!=null) {
            Map<Integer, Integer> left = DFS(root.left);
            leftMap.put(root.val,left);
        }
        if(root.right!=null){
            Map<Integer, Integer> right = DFS(root.right);
            rightMap.put(root.val,right);
        }
        int ans = cal(root,distance);
        return ans;
    }

    private int cal(TreeNode root, int distance) {
        if(root.left==null&&root.right==null)
            return 0;
        int num = 0;
        if(distance<0)
            return 0;
        Map<Integer,Integer> left = leftMap.get(root.val);
        Map<Integer,Integer> right = rightMap.get(root.val);
        for(int i = 0;i<=distance;i++){
            if(left.get(i)!=null&&right.get(distance-i)!=null){
                num+=(left.get(i)*right.get(distance-i));
            }
        }
        if(root.left!=null)
            num+=cal(root.left,distance);
        if(root.right!=null)
            num+=cal(root.right,distance);
        return num;
    }

    private Map<Integer, Integer> DFS(TreeNode root) {
        if(root.left==null&&root.right==null){
            Map<Integer,Integer> map = new HashMap<>();
            map.put(1,1);
            return map;
        }
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        if(root.left!=null){
            left = DFS(root.left);
            leftMap.put(root.val,left);
        }
        if(root.right!=null){
            right = DFS(root.right);
            rightMap.put(root.val,right);
        }
        Map<Integer,Integer> result = mergeMap(left,right);
        return result;
    }

    private Map<Integer, Integer> mergeMap(Map<Integer, Integer> left, Map<Integer, Integer> right) {
        Map<Integer,Integer> temp = new HashMap<>();
        Map<Integer,Integer> result = new HashMap<>();
        temp.putAll(left);
        for(Map.Entry<Integer,Integer> entry:right.entrySet()){
            Integer key = entry.getKey();
            temp.put(key,temp.getOrDefault(key,0)+entry.getValue());
        }
        for(Map.Entry<Integer,Integer> entry:temp.entrySet()){
            result.put(entry.getKey()+1,entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        Number_of_Good_Leaf_Nodes_Pairs test = new Number_of_Good_Leaf_Nodes_Pairs();
        System.out.println(test.countPairs(root,3));
    }
}
