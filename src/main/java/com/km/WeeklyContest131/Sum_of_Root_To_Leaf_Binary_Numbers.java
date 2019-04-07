package com.km.WeeklyContest131;

public class Sum_of_Root_To_Leaf_Binary_Numbers {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root,new StringBuilder(root.val+""));
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            ans = (ans + cal(sb)) % 1000000007;
            return;
        } else {
            if(node.left!=null){
                dfs(node.left,sb.append(node.left.val));
                sb.deleteCharAt(sb.length()-1);
            }
            if(node.right!=null){
                dfs(node.right,sb.append(node.right.val));
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public int cal(StringBuilder sb) {
        int res = 0;
        for (int i = 0; i < sb.length(); i++) {
            res = res * 2 + (sb.charAt(i) - '0');
            res = res % 1000000007;
        }

        System.out.println(res + "===" + sb.length());
        return res;
    }

    public static void main(String[] args) {
        Sum_of_Root_To_Leaf_Binary_Numbers test = new Sum_of_Root_To_Leaf_Binary_Numbers();
        TreeNode root = new TreeNode(1);
        System.out.println(test.sumRootToLeaf(root));
    }
}
