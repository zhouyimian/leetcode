package com.km.WeeklyContest132;

import java.util.HashMap;
import java.util.Map;

public class Recover_a_Tree_From_Preorder_Traversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        int sum = 0;
        int i = 0;
        Map<Integer,TreeNode> map = new HashMap<>();
        while(i<S.length()&&S.charAt(i)!='-'){
            sum = sum*10+(S.charAt(i)-'0');
            i++;
        }
        TreeNode root = new TreeNode(sum);
        map.put(0,root);
        while(i<S.length()){
            int depth = 0;
            int num = 0;
            while(i<S.length()&&S.charAt(i)=='-'){
                depth++;
                i++;
            }
            while(i<S.length()&&S.charAt(i)!='-'){
                num = num*10+(S.charAt(i)-'0');
                i++;
            }
            TreeNode node = new TreeNode(num);
            map.put(depth,node);

            TreeNode temp = map.getOrDefault(depth-1,null);
            if(temp==null) continue;
            else if(temp.left==null) temp.left = node;
            else if(temp.right==null) temp.right = node;
        }
        return root;
    }
    public static void main(String[] args) {
        String S = "1-401--349---90--88";
        Recover_a_Tree_From_Preorder_Traversal test = new Recover_a_Tree_From_Preorder_Traversal();
        test.recoverFromPreorder(S);
    }
}
