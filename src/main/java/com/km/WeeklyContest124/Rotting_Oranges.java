package com.km.WeeklyContest124;

public class Rotting_Oranges {
    int destorycount=0;
    int[][] dirt = {{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        while(true){
            destorycount=0;
            for(int i = 0;i<grid.length;i++){
                for(int j = 0;j<grid[i].length;j++){
                    if(grid[i][j]==2)
                        destory(grid,i,j);
                }
            }
            if(destorycount==0)
                break;
            ans++;
            destorycount=0;
            for(int i = 0;i<grid.length;i++){
                for(int j = 0;j<grid[i].length;j++){
                    if(grid[i][j]==-1)
                        grid[i][j]=2;
                }
            }
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return ans;
    }

    private void destory(int[][] grid, int line, int column) {
        for(int i = 0 ;i<4;i++){
            int x = dirt[i][0]+line;
            int y = dirt[i][1]+column;
            if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==1){
                destorycount++;
                grid[x][y]=-1;
            }
        }
    }
}
