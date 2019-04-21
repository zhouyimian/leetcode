package com.km.WeeklyContest133;

public class Maximum_Sum_of_Two_Non_Overlapping_Subarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int ans = 0;
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for(int i = 1;i<A.length;i++){
            sum[i] = sum[i-1]+A[i];
        }
        for(int i = 0;i<A.length;i++){
            if(i-L+1>=0) {
                for (int j = i; j < A.length; j++) {
                    if (j - i >= M) {
//                        System.out.println(sum[i] - (i-L<0?0:sum[i - L]));
//                        System.out.println(sum[j] - sum[j - M + 1]);
                        ans = Math.max(ans, (sum[i] - (i-L<0?0:sum[i - L])+ sum[j] - sum[j - M]));
                    }
                }
            }
        }
        int temp = L;
        L=M;
        M=temp;
        for(int i = 0;i<A.length;i++){
            if(i-L+1>=0) {
                for (int j = i; j < A.length; j++) {
                    if (j - i >= M) {
                        ans = Math.max(ans, (sum[i] - (i-L<0?0:sum[i - L])+ sum[j] - sum[j - M ]));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Maximum_Sum_of_Two_Non_Overlapping_Subarrays test = new Maximum_Sum_of_Two_Non_Overlapping_Subarrays();
        int[] nums = {3,8,1,3,2,1,8,9,0};
        System.out.println(test.maxSumTwoNoOverlap(nums,3,2));
    }
}
