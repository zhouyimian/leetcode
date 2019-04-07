package com.km.leetcode;

public class Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        int[] nums = new int[length];
        int index1 = 0,index2 = 0;
        int index = 0;
        while(index1<nums1.length&&index2<nums2.length){
            if(nums1[index1]<nums2[index2])
                nums[index++] = nums1[index1++];
            else
                nums[index++] = nums2[index2++];
        }
        if(index1>=nums1.length){
            while(index2<nums2.length)
                nums[index++] = nums2[index2++];
        }else{
            while(index1<nums1.length)
                nums[index++] = nums1[index1++];
        }
        if(length%2==0)
            return (nums[length/2-1]+nums[length/2])/2.0;
        else
            return nums[length/2];
    }

    public static void main(String[] args) {
        long num1 = -2147483647;
        long num2 = -1;
        System.out.println(num1/num2);
    }
}
