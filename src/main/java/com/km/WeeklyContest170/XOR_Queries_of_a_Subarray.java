package com.km.WeeklyContest170;

public class XOR_Queries_of_a_Subarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        if(arr.length==0||queries.length==0)
            return new int[queries.length];
        int[] ans = new int[queries.length];
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for(int i = 1;i<arr.length;i++){
            sum[i] = arr[i]^sum[i-1];
        }
        for(int i = 0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start==0){
                ans[i] = sum[end];
            }else if(start==end){
                ans[i] = arr[start];
            } else{
                ans[i] = sum[end]^sum[start-1];
            }
        }
        return ans;
    }
}
