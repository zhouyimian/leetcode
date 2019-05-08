package com.km.leetcode;

public class Rotate_Function {
    public int maxRotateFunction(int[] A) {
        int length = A.length;
        if(length==0)
            return 0;
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];
        leftSum[0] = 0;
        int ans = 0;
        rightSum[length-1] = 0;
        for(int i = 1;i<length;i++){
            leftSum[i] = leftSum[i-1]+A[i-1];
            ans+=i*A[i];
        }
        for(int i = length-2;i>=0;i--)
            rightSum[i] = rightSum[i+1]+A[i+1];
        int temp = ans;
        for(int i = 1;i<length;i++){
            temp = temp-rightSum[i]-leftSum[i-1]-A[i]+(length-1)*A[i-1];
            ans = Math.max(ans,temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Rotate_Function test = new Rotate_Function();
        System.out.println(test.maxRotateFunction(nums));
    }
}
