package com.km.WeeklyContest118;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Flip_Binary_Tree_To_Match_Preorder_Traversal {
    List<Integer> ans=new ArrayList<>();
    int index=0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        //
        if(!dfs(root,voyage)){
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }
    public boolean dfs(TreeNode root,int[] nums){
        if(root==null)
            return true;
        if(root.val!=nums[index++])
            return false;
        if(root.left!=null&&root.left.val==nums[index])
            return dfs(root.left,nums)&&dfs(root.right,nums);
        else if(root.right!=null&&root.right.val==nums[index]) {
            if (root.left != null) ans.add(root.val);
            return dfs(root.right,nums)&&dfs(root.left,nums);
        }
        return root.left==null&&root.right==null;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        int[] nums={1,3,2};
        Flip_Binary_Tree_To_Match_Preorder_Traversal test=new Flip_Binary_Tree_To_Match_Preorder_Traversal();
        for(int num:test.flipMatchVoyage(root,nums))
            System.out.println(num);
    }
}
