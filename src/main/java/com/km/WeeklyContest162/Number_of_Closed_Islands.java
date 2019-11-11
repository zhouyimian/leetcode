package com.km.WeeklyContest162;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Closed_Islands {
    int[][] dire = {{-1,0},{0,-1},{0,1},{1,0}};
    public int closedIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    if(BFS(grid,i,j)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean BFS(int[][] grid, int line, int column) {
        boolean ans = true;
        if(line==0||column==0||line==grid.length-1||column==grid[0].length-1)
            return false;
        List<Integer[]> queue = new ArrayList<>();
        queue.add(new Integer[]{line,column});
        while (queue.size()!=0){
            List<Integer[]> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                Integer[] now = queue.get(i);
                for(int j = 0;j<4;j++){
                    int x = dire[j][0]+now[0];
                    int y = dire[j][1]+now[1];
                    if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==1)
                        continue;
                    if(grid[x][y]==0&&(x==0||y==0||x==grid.length-1||y==grid[0].length-1)) {
                        grid[x][y] = 1;
                        ans = false;
                    }
                    temp.add(new Integer[]{x,y});
                    grid[x][y] = 1;
                }
            }
            queue.clear();
            queue.addAll(temp);
        }
        return ans;
    }

    private boolean check(int x, int y, boolean[][] vis, int[][] grid) {
        if(x<0||y<0||x>=vis.length||y>=vis[0].length||vis[x][y])
            return false;
        return true;
    }

    public static void main(String[] args) {
        Number_of_Closed_Islands test = new Number_of_Closed_Islands();
        int[][] grids = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}};
        System.out.println(test.closedIsland(grids));
    }
}
//[[],[],[],[],[],[],[]]