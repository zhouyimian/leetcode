package com.km.WeeklyContest133;

import java.util.ArrayList;
import java.util.List;

public class Matrix_Cells_in_Distance_Order {
    boolean[][] visit;
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        visit = new boolean[R][C];
        int[][] dire = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] map = new int[R][C];
        int[][] ans = new int[R*C][2];
        int index = 1;
        int[] first = {r0,c0};
        ans[0] = first;
        List<int[]> queue = new ArrayList<>();
        queue.add(first);
        while(true){
            List<int[]> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                int[] cur = queue.get(i);
                visit[cur[0]][cur[1]] = true;
                for(int j = 0;j<4;j++){
                    int x = cur[0]+dire[j][0];
                    int y = cur[1]+dire[j][1];
                    if(check(x,y)){
                        visit[x][y] = true;
                        int[] s = new int[2];
                        s[0] = x;s[1] = y;
                        temp.add(s);
                        ans[index][0] = x;
                        ans[index][1] = y;
                        index++;
                    }
                }
            }
            queue.clear();
            queue.addAll(temp);
            temp.clear();
            if(queue.size()==0)
                break;
        }
        return ans;

    }
    public boolean check(int x,int y){
        if(x<0||y<0||x>=visit.length||y>=visit[0].length||visit[x][y])
            return false;
        return true;
    }

    public static void main(String[] args) {
        Matrix_Cells_in_Distance_Order test = new Matrix_Cells_in_Distance_Order();
        test.allCellsDistOrder(1,2,0,0);
    }
}
