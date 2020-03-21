package com.Biweekly.BiweeklyContest22;

import java.util.*;

public class Cinema_Seat_Allocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans = n*3;
        Map<Integer,HashSet<Integer>> used = new HashMap<>();
        for(int[] nums:reservedSeats){
            HashSet<Integer> set = used.getOrDefault(nums[0],new HashSet<>());
            set.add(nums[1]);
            used.put(nums[0],set);
        }
        ans-=(n-used.size());
        for(Map.Entry<Integer,HashSet<Integer>> entry:used.entrySet()) {
            Set<Integer> set = entry.getValue();
            int count = 0;
            if(check(2,set)&&check(3,set)&&check(4,set)&&check(5,set)){
                count++;
                if(check(6,set)&&check(7,set)&&check(8,set)&&check(9,set)){
                    count++;
                }
            }
            else{
                if(check(4,set)&&check(5,set)&&check(6,set)&&check(7,set)){
                    count++;
                }else if(check(6,set)&&check(7,set)&&check(8,set)&&check(9,set)){
                    count++;
                }
            }
            ans-=(3-count);
        }
        return ans;
    }
    private boolean check(int column, Set<Integer> set) {
        return !set.contains(column);
    }

    public static void main(String[] args) {
        Cinema_Seat_Allocation test = new Cinema_Seat_Allocation();
        int[][] nums = {{4,3},{1,4},{4,6},{1,7}};
        System.out.println(test.maxNumberOfFamilies(4,nums));
    }
}
