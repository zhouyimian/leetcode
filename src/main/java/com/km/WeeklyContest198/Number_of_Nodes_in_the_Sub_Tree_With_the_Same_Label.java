package com.km.WeeklyContest198;

import java.util.*;

class TreeNode {
    int num;
    char label;
    int[] counts = new int[26];
    List<TreeNode> childs = new ArrayList<>();

    public TreeNode(int num, char label) {
        this.num = num;
        this.label = label;
    }
}

public class Number_of_Nodes_in_the_Sub_Tree_With_the_Same_Label {
    Map<Integer,TreeNode> map = new HashMap<>();
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int length = edges.length;
        TreeNode root = new TreeNode(0, labels.charAt(0));
        Set<Integer> set = new HashSet<>();
        map.put(0,root);
        set.add(0);
        for (int i = 0; i < length; i++) {
            int from = -1;
            int to = -1;
            if(set.contains(edges[i][0])){
                from = edges[i][0];
                to = edges[i][1];
            }else{
                from = edges[i][1];
                to = edges[i][0];
            }
            set.add(to);
            addEdge(map.get(from), to, labels);
        }
        buildCount(root);
        int[] ans = new int[n];
        DFS(root, ans);
        return ans;
    }

    private int[] buildCount(TreeNode root) {
        if (root == null)
            return new int[26];
        int[] cur = new int[26];
        cur[root.label - 'a'] = 1;
        for (TreeNode child : root.childs) {
            int[] sum = buildCount(child);
            for (int i = 0; i < 26; i++)
                cur[i] += sum[i];
        }
        root.counts = cur;
        return cur;
    }

    private void DFS(TreeNode root, int[] ans) {
        if (root == null)
            return;
        ans[root.num] = root.counts[root.label - 'a'];
        for (TreeNode child : root.childs)
            DFS(child, ans);
    }

    private void addEdge(TreeNode root, int to, String labels) {
        TreeNode child = new TreeNode(to, labels.charAt(to));
        root.childs.add(child);
        map.put(to,child);
    }

    public static void main(String[] args) {
        Number_of_Nodes_in_the_Sub_Tree_With_the_Same_Label test = new Number_of_Nodes_in_the_Sub_Tree_With_the_Same_Label();
        int[][] edges = {{0,2},{0,3},{1,2}};
        int[] res = test.countSubTrees(4,edges,"aeed");
        for(int num:res)
            System.out.println(num);
    }
}
