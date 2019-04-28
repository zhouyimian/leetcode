package com.km;

import java.util.Scanner;

public class test2 {
    static int[][] graph;
    static int[][] dire = {{0,1},{0,-1},{-1,0},{1,0}};
    static int ans = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int row = sc.nextInt();
        graph = new int[line][row];
        for(int i = 0;i<line;i++){
            for(int j = 0;j<row;j++){
                graph[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i<line;i++){
            for(int j = 0;j<row;j++){
                dfs(i,j,1);
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int line,int row,int length){
        for(int i = 0;i<4;i++){
            int x = line+dire[i][0];
            int y = row+dire[i][1];
            if(check(x,y)&&graph[x][y]>graph[line][row]){
                ans = Math.max(ans,length+1);
                dfs(x,y,length+1);
            }
        }
    }

    private static boolean check(int x, int y) {
        if(x<0||y<0||x>=graph.length||y>=graph[x].length)
            return false;
        return true;
    }
}
