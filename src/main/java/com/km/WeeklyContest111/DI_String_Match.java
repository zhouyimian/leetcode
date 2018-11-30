package com.km.WeeklyContest111;

public class DI_String_Match {
    public int[] diStringMatch(String S) {
        int[] ans=new int[S.length()+1];
        int left = 0,right = S.length();
        for(int i=0;i<S.length();i++)
            ans[i] = S.charAt(i)=='I'?left++:right--;
        ans[S.length()] = left;
        return ans;
    }
}
