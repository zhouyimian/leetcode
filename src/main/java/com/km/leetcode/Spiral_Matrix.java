package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int dire=0;  //0 go right;1 go down ;2 go left ;3 go up
        if(matrix.length==0||matrix[0].length==0) {
            return ans;
        }
        int line=matrix.length;
        int col=matrix[0].length;
        int[][] vis=new int[line][col];
        int count=0;
        int nowline=0,nowcol=0;
        while(count<line*col){
            ans.add(matrix[nowline][nowcol]);
            vis[nowline][nowcol]=1;
            if(dire==0){
                if(nowcol==col-1||vis[nowline][nowcol+1]==1){
                    dire=1;
                    nowline++;
                }
                else{
                    nowcol++;
                }
            }
            else if(dire==1){
                if(nowline==line-1||vis[nowline+1][nowcol]==1){
                    dire=2;
                    nowcol--;
                }
                else{
                    nowline++;
                }
            }
            else if(dire==2){
                if(nowcol==0||vis[nowline][nowcol-1]==1){
                    dire=3;
                    nowline--;
                }
                else{
                    nowcol--;
                }
            }
            else{
                if(nowline==0||vis[nowline-1][nowcol]==1){
                    dire=0;
                    nowcol++;
                }
                else{
                    nowline--;
                }
            }
            count++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Spiral_Matrix test=new Spiral_Matrix();
        int[][] nums={{1,2,3,4,5,6,7,8,9}};
        for(int num:test.spiralOrder(nums)){
            System.out.println(num);
        }
    }
}
