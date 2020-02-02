package com.km.WeeklyContest174;

public class Maximum_Product_of_Splitted_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    class MyTreeNode{
        int val;
        MyTreeNode left;
        MyTreeNode right;
        long leftSum = 0;
        long rightSum = 0;
        MyTreeNode(int x) {
            val = x;
        }
    }
    long sum = 0;
    long max = 0;
    int mod = 1000000007;
    public int maxProduct(TreeNode root) {

        if(root==null)
            return 0;
        MyTreeNode myroot = new MyTreeNode(root.val);
        myroot = copyTree(root,myroot);
        myroot.leftSum = cal(myroot.left);
        myroot.rightSum = cal(myroot.right);
        sum = myroot.leftSum+myroot.rightSum+myroot.val;
        dfs(myroot);
        return (int) (max%mod);
    }

    private void dfs(MyTreeNode root) {
        if(root==null)
            return;
        max = Math.max(max,root.leftSum*(sum-root.leftSum));
        max = Math.max(max,root.rightSum*(sum-root.rightSum));
        dfs(root.left);
        dfs(root.right);
    }

    private long cal(MyTreeNode root) {
        if(root==null)
            return 0;
        root.leftSum = cal(root.left);
        root.rightSum = cal(root.right);
        return root.leftSum+root.rightSum+root.val;
    }

    private MyTreeNode copyTree(TreeNode root, MyTreeNode myroot) {
        if(root==null)
            return null;
        myroot = new MyTreeNode(root.val);
        myroot.left = copyTree(root.left,myroot.left);
        myroot.right = copyTree(root.right,myroot.right);
        return myroot;
    }
}
