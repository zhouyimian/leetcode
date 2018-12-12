package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;


public class N_ary_Tree_Postorder_Traversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }
    }
    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        deal(root);
        return ans;
    }

    private void deal(Node root) {
        if (root == null)
            return;
        for (Node node : root.children) {
            deal(node);
        }
        ans.add(root.val);
    }
}
