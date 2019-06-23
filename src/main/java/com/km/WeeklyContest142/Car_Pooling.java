package com.km.WeeklyContest142;

import java.util.*;

public class Car_Pooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] nums1, int[] nums2) {
                return nums1[1]!=nums2[1]?nums1[1]-nums2[1]:nums1[2]-nums2[2];
            }
        });
        Map<Integer,Integer> leave_count = new TreeMap<>();
        Map<Integer,Integer> add_count = new TreeMap<>();
        for(int i = 0;i<trips.length;i++){
            leave_count.put(trips[i][2],leave_count.getOrDefault(trips[i][2],0)+trips[i][0]);
            add_count.put(trips[i][1],add_count.getOrDefault(trips[i][1],0)+trips[i][0]);
        }

        int cur_count = 0;
        for(int i = 0;i<=1010;i++){
            int add_num = add_count.getOrDefault(i,0);
            int leave_num = leave_count.getOrDefault(i,0);
            cur_count-=leave_num;
            cur_count+=add_num;
            if(cur_count>capacity)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        Car_Pooling test = new Car_Pooling();
        System.out.println(test.carPooling(trips,5));
    }
}
