package com.km.WeeklyContest144;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delete_Nodes_And_Return_Forest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Set<Integer> set;
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for (int num : to_delete) {
            set.add(num);
        }
        dfs(root, true);
        return ans;
    }

    public TreeNode dfs(TreeNode root, boolean is_Root) {
        if (root == null)
            return null;
        boolean delete = set.contains(root.val);
        if (is_Root && !delete) ans.add(root);
        root.left = dfs(root.left, delete);
        root.right = dfs(root.right, delete);
        return delete ? null : root;
    }
}
