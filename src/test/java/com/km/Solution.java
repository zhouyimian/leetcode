package com.km;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    private Node createBinaryTreeByArray(Integer[] array,int index)
    {
        Node tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new Node(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

    public int levelOrder(Node root){
        List<List<Integer>> queue = new ArrayList<>();
        queue.add(new ArrayList<>());
        queue.get(0).add(root.val);
        dfs(root.left,1,queue);
        dfs(root.right,1,queue);
        double ans = root.val;
        int ansindex = 1;
        for(int i = 0;i<queue.size();i++){
            int sum = 0;
            List<Integer> temp = queue.get(i);
            for(int num:temp)
                sum+=num;
            if(sum/(temp.size()+0.0)>=ans){
                ans = sum/(temp.size()+0.0);
                ansindex = i+1;
            }
        }
        return ansindex;
    }

    private void dfs(Node root, int ceng, List<List<Integer>> queue) {
        if(root==null)
            return;
        if(queue.size()<=ceng){
            queue.add(new ArrayList<>());
        }
        queue.get(ceng).add(root.val);
        dfs(root.left,ceng+1,queue);
        dfs(root.right,ceng+1,queue);
    }


    public  Node createTree(int[] array){
        List<Node> nodeList=new LinkedList<Node>();

        for(int nodeIndex=0;nodeIndex<array.length;nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        for(int parentIndex=0;parentIndex<=array.length/2-1;parentIndex++){
            nodeList.get(parentIndex).left =nodeList.get(parentIndex*2+1);
            //防止是非完全二叉树
            if((parentIndex*2+2)<array.length) {
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }
        return nodeList.get(0);
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int [] array = new int [n];
        Integer [] array = new Integer[n];
        for(int i = 0;i < n;i++){
            String value =scanner.next();
            if(value.equals( "null" )){
                array[i]=null;
            }else{
                array[i] = Integer.valueOf( value );
            }

        }
        Solution solution = new Solution ();
        Node root =solution.createBinaryTreeByArray(array,0);
        int level = solution.levelOrder( root );
        System.out.println(level);

    }
}
