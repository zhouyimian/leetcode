package com.km.WeeklyContest158;

public class Split_a_String_in_Balanced_Strings {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int leftcount = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='L')
                leftcount++;
            else
                leftcount--;
            if(leftcount==0)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
