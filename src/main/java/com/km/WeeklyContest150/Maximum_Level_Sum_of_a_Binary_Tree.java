package com.km.WeeklyContest150;

import java.util.ArrayList;
import java.util.List;

public class Maximum_Level_Sum_of_a_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        int depth = 1;
        int ans = 1;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size()!=0){
            List<TreeNode> temp = new ArrayList<>();
            int val = 0;
            for(int i = 0;i<queue.size();i++){
                TreeNode cur = queue.get(i);
                val+=cur.val;
                if(cur.left!=null)
                    temp.add(cur.left);
                if(cur.right!=null)
                    temp.add(cur.right);
            }
            if(val>max){
                max = val;
                ans = depth;
            }
            depth++;
            queue.clear();
            queue.addAll(temp);
        }
        return ans;
    }
}
