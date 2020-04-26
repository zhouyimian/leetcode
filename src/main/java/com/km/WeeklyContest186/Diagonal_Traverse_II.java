package com.km.WeeklyContest186;

import java.util.*;

public class Diagonal_Traverse_II {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int cols = 0;
        for(int i = nums.size()-1;i>=0;i--){
            size+=nums.get(i).size();
            for(int j = 0;j<nums.get(i).size();j++){
                map.putIfAbsent(i+j,new ArrayList<>());
                map.get(i+j).add(nums.get(i).get(j));
            }
            cols = Math.max(cols,nums.get(i).size());
        }
        int[] ans = new int[size];
        int index = 0;
        for(int key = 0;key<=cols+nums.size();key++){
            List<Integer> value = map.get(key);
            if(value==null) continue;
            for(int num:value) ans[index++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Diagonal_Traverse_II test = new Diagonal_Traverse_II();
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1,2,3));
        nums.add(Arrays.asList(4,5,6));
        nums.add(Arrays.asList(7,8,9));
        int[] res = test.findDiagonalOrder(nums);
        for(int num :res)
            System.out.println(num);
    }
}
