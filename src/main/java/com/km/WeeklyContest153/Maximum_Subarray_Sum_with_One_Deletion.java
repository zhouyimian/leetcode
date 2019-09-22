package com.km.WeeklyContest153;

public class Maximum_Subarray_Sum_with_One_Deletion {
    public int maximumSum(int[] arr) {
        int max = arr[0];
        int[] maxStartHere = new int[arr.length];
        int[] maxEndHere = new int[arr.length];
        for(int i = 1;i<arr.length;i++){
            maxEndHere[i] = Math.max(arr[i],arr[i-1]+arr[i]);
            max = Math.max(max,maxEndHere[i]);
        }
        maxStartHere[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2;i>=0;i--)
            maxStartHere[i] = Math.max(arr[i],arr[i]+maxStartHere[i+1]);
        for(int i = 1;i<arr.length-1;i++)
            max = Math.max(max,maxEndHere[i-1]+maxStartHere[i+1]);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,-2,0,3};
        Maximum_Subarray_Sum_with_One_Deletion t = new Maximum_Subarray_Sum_with_One_Deletion();
        System.out.println(t.maximumSum(nums));

    }
}
//[]