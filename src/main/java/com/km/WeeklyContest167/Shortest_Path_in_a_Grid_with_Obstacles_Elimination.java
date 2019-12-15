package com.km.WeeklyContest167;

import java.util.HashMap;
import java.util.Map;

public class Shortest_Path_in_a_Grid_with_Obstacles_Elimination {
    int line;
    int column;
    boolean[][] vis;
    int ans = Integer.MAX_VALUE;
    int[][] dire = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    Map<String,Integer> map = new HashMap<>();
    public int shortestPath(int[][] grid, int k) {
        int obstacle = 0;
        line = grid.length;
        column = grid[0].length;
        vis = new boolean[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1)
                    obstacle++;
            }
        }
        vis[0][0]=true;
        if (k >= obstacle)
            return line + column - 2;
        ans = DFS(0, 0,  k, grid);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int DFS(int curx, int cury,  int restK, int[][] grid) {
        if(restK<0)
            return Integer.MAX_VALUE;
        if (curx == grid.length - 1 && cury == grid[0].length - 1) {
            return 0;
        }
        String key = curx+"_"+cury+"_"+restK;
        if(map.containsKey(key))
            return map.get(key);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int x = curx + dire[i][0];
            int y = cury + dire[i][1];
            int temp = Integer.MAX_VALUE;
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || vis[x][y]) {
                continue;
            } else {
                if (grid[x][y] == 0) {
                    vis[x][y] = true;
                    temp = DFS(x, y,  restK, grid);
                    vis[x][y] = false;
                } else {
                    if (restK > 0) {
                        vis[x][y] = true;
                        temp = DFS(x, y, restK-1, grid);
                        vis[x][y] = false;
                    }
                }
                if(temp!=Integer.MAX_VALUE)
                    min = Math.min(min,temp+1);
            }
        }
        map.put(key,min);
        return min;
    }

    public static void main(String[] args) {
        Shortest_Path_in_a_Grid_with_Obstacles_Elimination test = new Shortest_Path_in_a_Grid_with_Obstacles_Elimination();
        int[][] grid = {{0,1,1},{1,1,1},{1,0,0}};
        System.out.println(test.shortestPath(grid,1));
    }
}
