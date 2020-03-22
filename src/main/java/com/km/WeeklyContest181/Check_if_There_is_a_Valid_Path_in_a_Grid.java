package com.km.WeeklyContest181;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Check_if_There_is_a_Valid_Path_in_a_Grid {
    int[][][] dirs = {
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {-1, 0}}
    };
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        vis[0][0] = true;
        while (queue.size() != 0) {
            int[] cur = queue.poll();
            int x = cur[0],y = cur[1];
            int num = grid[x][y]-1;
            for(int[] dir:dirs[num]){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;
                for (int[] backDir : dirs[grid[nx][ny] - 1])
                    if (nx + backDir[0] == x && ny + backDir[1] == y) {
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
            }
        }
        return vis[m-1][n-1];
    }
}

