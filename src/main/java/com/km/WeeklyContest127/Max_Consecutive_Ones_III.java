package com.km.WeeklyContest127;

public class Max_Consecutive_Ones_III {
    public int longestOnes(int[] A, int K) {
        int start = 0;
        int end = 0;
        int use = 0;
        int ans = 0;
        while(end!=A.length){
            if(A[end]==0&&use+1<=K)
                use++;
            else if(A[end]==0&&use+1>K){
                while(start<=end){
                    if(A[start]==0){
                        start++;
                        break;
                    }
                    start++;
                }
            }
            ans = Math.max((end-start+1),ans);
            end++;
        }
        return ans;
    }
}
