package com.km.WeeklyContest117;

public class Binary_Tree_Cameras {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int ans=0;
    public int minCameraCover(TreeNode root) {
        return (dfs(root)<1?1:0)+ans;
    }
    public int dfs(TreeNode root){
        int needcarmer=0,cover=0;
        if(root.left==null&&root.right==null)
            return 0;
        if(root.left!=null){
            int state=dfs(root.left);
            if(state==0){
                needcarmer=1;
                cover=1;
            }else if(state==1)
                cover=1;
        }
        if(root.right!=null){
            int state=dfs(root.right);
            if(state==0){
                needcarmer=1;
                cover=1;
            }else if(state==1)
                cover=1;
        }
        if(needcarmer==1) {
            ans++;
            return 1;
        }
        if(cover>0)
            return 2;
        return 0;

    }
}
