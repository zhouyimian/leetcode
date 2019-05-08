package com.km.leetcode;

import java.util.Arrays;

public class Longest_Substring_with_At_Least_K_Repeating_Characters {
    public int longestSubstring(String s, int k) {
        int[] count = new int[26];
        Arrays.fill(count,0);
        int length = s.length();
        if(length<k)
            return 0;
        for(int i = 0;i<length;i++)
            count[s.charAt(i)-'a']++;
        int index = 0;
        while(index<length&&count[s.charAt(index)-'a']>=k)
            index++;
        if(index==length)
            return length;
        int left = longestSubstring(s.substring(0,index),k);
        int right = longestSubstring(s.substring(index+1),k);
        return Math.max(left,right);
    }
    public static void main(String[] args) {
        String s = "weitong";
        Longest_Substring_with_At_Least_K_Repeating_Characters test = new Longest_Substring_with_At_Least_K_Repeating_Characters();
        System.out.println(test.longestSubstring(s,2));
    }
}
