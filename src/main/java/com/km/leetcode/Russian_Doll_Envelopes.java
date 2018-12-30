package com.km.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int ans=0;
        int len=envelopes.length;
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] env1, int[] env2) {
                if(env1[0]==env2[0])
                    return env1[1]-env2[1];
                else
                    return env1[0]-env2[0];
            }
        });
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums={{5,4},{6,4},{6,7},{2,3}};
        Russian_Doll_Envelopes test=new Russian_Doll_Envelopes();
        System.out.println(test.maxEnvelopes(nums));
    }
}
