package com.Biweekly.BiweeklyContest19;

public class Number_of_Sub_arrays_of_Size_K_and_Average_Greater_than_or_Equal_to_Threshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        double[] sum = new double[arr.length];
        sum[0] = arr[0];
        for(int i = 1;i<arr.length;i++)
            sum[i] = sum[i-1]+arr[i];
        for(int i = 0;i<arr.length-k;i++){
            int end = i+k;
            if(i==0){
                if(sum[i+k-1]/k>=threshold){
                    ans++;
                }
            }else{
                if((sum[i+k-1]-sum[i-1])/k>=threshold){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {};
    }
}
