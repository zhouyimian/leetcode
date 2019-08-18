package com.km.WeeklyContest150;

import java.util.ArrayList;
import java.util.List;

public class As_Far_from_Land_as_Possible {
    int[][] dire = {{-1,0},{1,0},{0,-1},{0,1}};
    public int maxDistance(int[][] grid) {
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    ans = Math.max(ans,cul(i,j,grid));
                }
            }
        }
        return ans==0?-1:ans;
    }

    private int cul(int curline, int curcolumn, int[][] grid) {
        List<Integer[]> queue = new ArrayList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        vis[curline][curcolumn] = true;
        queue.add(new Integer[]{curline,curcolumn});
        while (queue.size()!=0){
            List<Integer[]> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                Integer[] now = queue.get(i);
                if(grid[now[0]][now[1]]==1){
                    return Math.abs(curline-now[0])+Math.abs(curcolumn-now[1]);
                }
                for(int j = 0;j<4;j++){
                    int x = now[0]+dire[j][0];
                    int y = now[1]+dire[j][1];
                    if(check(x,y,vis)){
                        vis[x][y] = true;
                        temp.add(new Integer[]{x,y});
                    }
                }
            }
            queue.clear();
            queue.addAll(temp);
        }
        return 0;
    }

    private boolean check(int x, int y, boolean[][] vis) {
        if(x<0||y<0||x>=vis.length||y>=vis[0].length||vis[x][y])
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,1}};
        As_Far_from_Land_as_Possible t = new As_Far_from_Land_as_Possible();
        System.out.println(t.maxDistance(graph));
    }
}
