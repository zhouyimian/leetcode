package com.km.WeeklyContest139;

import java.util.ArrayList;
import java.util.List;

public class Adding_Two_Negabinary_Numbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int[] ans = new int[Math.max(arr1.length,arr2.length)+2];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = arr1.length-1;i>=0;i--)
            list1.add(arr1[i]);
        for(int i = arr2.length-1;i>=0;i--)
            list2.add(arr2[i]);
        int index = 0;
        while(index<list1.size()&&index<list2.size()){
            ans[index] = list1.get(index)+list2.get(index);
            index++;
        }
        if(arr1.length<arr2.length){
            while(index<arr2.length)
                ans[index] = list2.get(index++);
        }else if(arr1.length>arr2.length){
            while(index<arr1.length)
                ans[index] = list1.get(index++);
        }
        for(int i = 0;i<ans.length;i++){
            while (ans[i]>=2&&ans[i+1]>0){
                ans[i]-=2;
                ans[i+1]--;
            }
            if(ans[i]>=2){
                ans[i]-=2;
                ans[i+1]++;
                ans[i+2]++;
            }
        }
        int end = ans.length-1;
        while(ans[end]==0&&end>0) end--;
        int[] res = new int[end+1];
        for(int i = 0;i<=end;i++)
            res[i] = ans[i];
        reverse(res);
        return res;
    }
    public void reverse(int[] nums){
        for(int i = 0;i<nums.length/2;i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {0};
        Adding_Two_Negabinary_Numbers test = new Adding_Two_Negabinary_Numbers();
        int[] res = test.addNegabinary(nums1,nums2);
        for(int num:res)
            System.out.println(num);
    }
}
