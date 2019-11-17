package com.km.WeeklyContest163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shift_2D_Grid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int size = grid.length*grid[0].length;
        k%=size;
        for(int i = 0;i<grid.length;i++){
            ans.add(Arrays.asList(new Integer[grid[0].length]));
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                int newX = i+(k/grid[0].length);
                int newY = j+(k%grid[0].length);
                if(newY>=grid[0].length){
                    newY%=grid[0].length;
                    newX++;
                }
                if(newX>=grid.length){
                    newX%=grid.length;
                }
                ans.get(newX).set(newY,grid[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        Shift_2D_Grid test = new Shift_2D_Grid();
        System.out.println(test.shiftGrid(nums,1));
    }
}
