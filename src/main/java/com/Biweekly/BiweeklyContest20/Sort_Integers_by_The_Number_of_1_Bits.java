package com.Biweekly.BiweeklyContest20;

import java.util.Arrays;
import java.util.Comparator;

public class Sort_Integers_by_The_Number_of_1_Bits {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for(int i = 0;i<nums.length;i++)
            nums[i] = arr[i];
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int temp1 = o1;
                int temp2 = o2;
                int count1 = 0;
                int count2 = 0;
                while (temp1!=0){
                    count1++;
                    temp1&=(temp1-1);
                }
                while (temp2!=0){
                    count2++;
                    temp2&=(temp2-1);
                }
                return count1==count2?o1-o2:count1-count2;
            }
        });
        for(int i = 0;i<nums.length;i++)
            arr[i] = nums[i];
        return arr;
    }

    public static void main(String[] args) {
        Sort_Integers_by_The_Number_of_1_Bits test = new Sort_Integers_by_The_Number_of_1_Bits();
        int[] nums = {8,4,2,1};
        nums = test.sortByBits(nums);
        for(int num:nums)
            System.out.println(num);
    }

    private static int myCal(int num) {
        int count = 0;
        while (num!=0){
            count++;
            num&=(num-1);
        }
        return count;
    }
}
