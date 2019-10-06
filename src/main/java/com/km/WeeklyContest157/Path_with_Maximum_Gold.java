package com.km.WeeklyContest157;

public class Path_with_Maximum_Gold {
    int[][] dist = {{-1,0},{0,-1},{0,1},{1,0}};
    int ans = 0;
    boolean[][] vis;
    public int getMaximumGold(int[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j]!=0) {
                    vis[i][j] = true;
                    dfs(i, j, grid, grid[i][j]);
                    vis[i][j] = false;
                }
            }
        }
        return ans;
    }

    private void dfs(int line, int column, int[][] grid,int temp) {
        ans = Math.max(ans,temp);
        for(int i = 0;i<4;i++){
            int x = line+dist[i][0];
            int y = column+dist[i][1];
            if(check(x,y,vis)&&grid[x][y]!=0){
                vis[x][y] = true;
                dfs(x,y,grid,temp+grid[x][y]);
                vis[x][y] = false;
            }
        }
    }

    private boolean check(int x, int y, boolean[][] vis) {
        if(x<0||y<0||x>=vis.length||y>=vis[0].length||vis[x][y])
            return false;
        return true;
    }

    public static void main(String[] args) {
        Path_with_Maximum_Gold test = new Path_with_Maximum_Gold();
        int[][] nums = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(test.getMaximumGold(nums));
    }
}
