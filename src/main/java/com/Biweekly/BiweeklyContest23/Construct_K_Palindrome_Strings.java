package com.Biweekly.BiweeklyContest23;

public class Construct_K_Palindrome_Strings {
    public boolean canConstruct(String s, int k) {
        if(k>s.length())
            return false;
        if(k==s.length())
            return true;
        int[] nums = new int[26];
        for(char c:s.toCharArray())
            nums[c-'a']++;
        int jishuCount = 0;
        for(int num:nums){
            if(num%2!=0)
                jishuCount++;
        }
        if(jishuCount<=1)
            return true;
        if(k>=jishuCount)
            return true;
        return false;
    }
}
