package com.km.WeeklyContest134;

public class Coloring_A_Border {
    int[][] dire = {{1,0},{-1,0},{0,-1},{0,1}};
    int[][] vis;
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int source = grid[r0][c0];
        vis = new int[grid.length][grid[0].length];
        grid[r0][c0] = -1;
        dfs(source,grid,r0,c0);
        for(int i = 1;i<grid.length-1;i++){
            for(int j = 1;j<grid[i].length-1;j++){
                if(grid[i][j]==-1&&search(grid,i,j)){
                    grid[i][j] = -2;
                }
            }
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j]==-1){
                    grid[i][j] = color;
                }
                if(grid[i][j]==-2){
                    grid[i][j] = source;
                }
            }
        }
        return grid;
    }
    public void dfs(int source,int[][] grid,int line,int row){
        for(int i = 0;i<4;i++){
            int x = line + dire[i][0];
            int y = row + dire[i][1];
            if(check(x,y)){
                if(grid[x][y]==source){
                    grid[x][y] = -1;
                    dfs(source,grid,x,y);
                }
            }
        }
    }
    public boolean check(int x,int y){
        if(x<0||y<0||x>=vis.length||y>=vis[0].length)
            return false;
        return true;
    }
    public boolean search(int[][] grid,int line,int row){
        for(int i = 0;i<4;i++){
            int x = dire[i][0] + line;
            int y = dire[i][1] + row;
            if(grid[x][y]==-2)
                continue;
            if(grid[x][y]!=-1)
                return false;
        }
        return true;
    }
}
