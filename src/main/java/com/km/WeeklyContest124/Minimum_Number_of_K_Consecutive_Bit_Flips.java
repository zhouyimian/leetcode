package com.km.WeeklyContest124;

public class Minimum_Number_of_K_Consecutive_Bit_Flips {
    /*public int minKBitFlips(int[] A, int K) {
        int ans = 0;
        for(int i =0;i<A.length;i++){
            if(A[i]==0){
                if(A.length-i<K)
                    return -1;
                flip(A,K,i);
                ans++;
            }
        }
        return ans;
    }

    private void flip(int[] A, int K, int i) {
        for(int j=i;j<i+K;j++){
            A[j]=1-A[j];
        }
    }*/

    //上面是本人渣代码210ms 下面大佬代码9ms
    public int minKBitFlips(int[] A, int K) {
        int n = A.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < A.length; ++i) {
            if (i >= K)
                flipped ^= isFlipped[i - K];
            if (flipped == A[i]) {
                if (i + K > A.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }

}
