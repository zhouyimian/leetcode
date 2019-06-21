package com.km.WeeklyContest141;

import java.util.ArrayList;

public class Shortest_Path_in_Binary_Matrix {
    int[][] dire = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    boolean[][] vis;
    class Position{
        int x;
        int y;
        public Position(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        if(grid[0][0]==1)
            return -1;
        vis = new boolean[grid.length][grid[0].length];
        ArrayList<Position> queue = new ArrayList<>();
        queue.add(new Position(0,0));
        boolean flag = false;
        int ans = 1;
        vis[0][0] = true;
        while(queue.size()!=0&&!flag){
            ArrayList<Position> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                Position cur = queue.get(i);
                for(int j = 0;j<8;j++){
                    int x = cur.x+dire[j][0];
                    int y = cur.y+dire[j][1];
                    if(check(x,y,grid)){
                        temp.add(new Position(x,y));
                        vis[x][y] = true;
                        if(x==grid.length-1&&y==grid[0].length-1){
                            flag = true;
                            break;
                        }
                    }
                }
            }
            ans++;
            queue.clear();
            queue.addAll(temp);
        }
        if(flag)
            return ans;
        else
            return -1;
    }

    private boolean check(int x, int y,int[][]grid) {
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||vis[x][y]||grid[x][y]==1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Shortest_Path_in_Binary_Matrix test = new Shortest_Path_in_Binary_Matrix();
        int[][] map = {{0,1},{1,0}};
        System.out.println(test.shortestPathBinaryMatrix(map));
    }
}
