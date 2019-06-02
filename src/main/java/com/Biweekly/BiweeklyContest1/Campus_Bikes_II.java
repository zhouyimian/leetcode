package com.Biweekly.BiweeklyContest1;

public class Campus_Bikes_II {
    int[] vis;
    int[] pos;
    int ans = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        vis = new int[bikes.length];
        pos = new int[workers.length];
        dfs(0,workers,bikes);
        return ans;
    }
    public void dfs(int count,int[][] workers,int[][] bikes){
        if(count==workers.length){
            ans = Math.min(ans,deal(workers,bikes));
            return;
        }
        for(int i = 0;i<bikes.length;i++){
            if(vis[i]==0){
                pos[count] = i;
                vis[i] = 1;
                dfs(count+1,workers,bikes);
                vis[i] = 0;
                pos[count] = 0;
            }
        }
    }
    public int deal(int[][] workers,int[][] bikes){
        int result = 0;
        for(int i = 0;i<workers.length;i++){
            result+=(Math.abs(workers[i][0]-bikes[pos[i]][0])+Math.abs(workers[i][1]-bikes[pos[i]][1]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] workers = {{0,0},{1,1},{2,0}};
        int[][] bikes = {{1,0},{2,2},{2,1}};
        Campus_Bikes_II test = new Campus_Bikes_II();
        System.out.println(test.assignBikes(workers,bikes));
    }
}
//[[0,0],[1,1],[2,0]]
//        [[1,0],[2,2],[2,1]]