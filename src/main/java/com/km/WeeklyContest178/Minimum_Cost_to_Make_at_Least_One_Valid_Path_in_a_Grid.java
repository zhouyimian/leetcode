package com.km.WeeklyContest178;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid {
    int[][] dir = {{0,0},{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        List<Integer[]> queue = new ArrayList<>();
        boolean[][] vis = new boolean[m][n];
        DFS(vis,grid,0,0,queue);
        while (queue.size()!=0){
            List<Integer[]> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                Integer[] cur = queue.get(i);
                if(cur[0]==grid.length-1&&cur[1]==grid[0].length-1)
                    return ans;
                for(int j = 1;j<=4;j++){
                    int x = cur[0]+dir[j][0];
                    int y = cur[1]+dir[j][1];
                    DFS(vis,grid,x,y,temp);
                }
            }
            ans++;
            queue.clear();
            queue.addAll(temp);
        }
        return ans;
    }

    private void DFS(boolean[][] vis, int[][] grid, int line, int column, List<Integer[]> queue) {
        int m = grid.length,n = grid[0].length;
        while (line>=0&&column>=0&&line<m&&column<n&&!vis[line][column]){
            queue.add(new Integer[]{line,column});
            vis[line][column] = true;
            int templine = line;
            int tempcolumn = column;
            line+=dir[grid[templine][tempcolumn]][0];
            column+=dir[grid[templine][tempcolumn]][1];
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{3,4,3},{2,2,2},{2,1,1}};
        Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid test = new Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid();
        System.out.println(test.minCost(grid));
    }
}
