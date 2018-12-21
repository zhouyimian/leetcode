package com.km.leetcode;

import java.util.List;


public class Maximum_Depth_of_N_ary_Tree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int ans = 0;
        for (Node node : root.children)
            ans = Math.max(maxDepth(node), ans);
        return ans+1;
    }
}
