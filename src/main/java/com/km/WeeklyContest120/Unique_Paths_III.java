package com.km.WeeklyContest120;

public class Unique_Paths_III {
    int res = 0,ex = 0, ey = 0,  empty = 1;
    public int uniquePathsIII(int[][] grid) {
        int sx = 0, sy = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
                if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }

    public void dfs(int[][] grid, int x0, int y0) {
        if(check(grid,x0,y0)==false) return;
        if(x0==ex&&y0==ey&&empty==0){
            res++;
            return;
        }
        grid[x0][y0]=-2;
        empty--;
        dfs(grid,x0+1,y0);
        dfs(grid,x0-1,y0);
        dfs(grid,x0,y0+1);
        dfs(grid,x0,y0-1);
        grid[x0][y0]=0;
        empty++;
    }

    public boolean check(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        return 0 <= i && i < m && 0 <= j && j < n && grid[i][j] >= 0;
    }
}
