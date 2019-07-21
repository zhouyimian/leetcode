package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Enclaves {
    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numEnclaves(int[][] A) {
        List<Node> ans = new ArrayList<>();
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;
        boolean[][] vis = new boolean[A.length][A[0].length];
        int[][] dire = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        List<Node> queue = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1)
                    count++;
            }
        }
        for (int i = 0; i < A[0].length; i++) {
            if (A[0][i] == 1) {
                queue.add(new Node(0, i));
                vis[0][i] = true;
            }
            if (A[A.length - 1][i] == 1) {
                queue.add(new Node(A.length - 1, i));
                vis[A.length - 1][i] = true;
            }
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i][0] == 1) {
                queue.add(new Node(i, 0));
                vis[i][0] = true;
            }
            if (A[i][A[0].length - 1] == 1) {
                queue.add(new Node(i, A[0].length - 1));
                vis[i][A[0].length - 1] = true;
            }
        }
        ans.addAll(queue);
        while (queue.size() != 0) {
            List<Node> temp = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                Node cur = queue.get(i);
                for (int j = 0; j < 4; j++) {
                    int x = cur.x + dire[j][0];
                    int y = cur.y + dire[j][1];
                    if (check(x, y, vis, A)) {
                        vis[x][y] = true;
                        temp.add(new Node(x, y));
                    }
                }
            }
            queue.clear();
            queue.addAll(temp);
            ans.addAll(temp);
        }

        return count - ans.size();
    }

    private boolean check(int x, int y, boolean[][] vis, int[][] map) {
        if (x < 0 || y < 0 || x >= vis.length || y >= vis[0].length || vis[x][y] || map[x][y] == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        //[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
        int[][] nums = {{0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};
        Number_of_Enclaves test = new Number_of_Enclaves();
        System.out.println(test.numEnclaves(nums));
    }
}
