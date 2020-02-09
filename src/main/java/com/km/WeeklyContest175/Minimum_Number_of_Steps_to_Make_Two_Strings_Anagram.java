package com.km.WeeklyContest175;

public class Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {
    public int minSteps(String s, String t) {
        int[] source = new int[26];
        int[] target = new int[26];
        for(char c:s.toCharArray())
            target[c-'a']++;
        for(char c:t.toCharArray())
            source[c-'a']++;
        int ans = 0;
        for(int i = 0;i<26;i++)
            ans+=Math.abs(source[i]-target[i]);
        return (ans%2==0)?ans/2:ans/2+1;
    }

    public static void main(String[] args) {
        Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram test = new Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram();
        System.out.println(test.minSteps("leetcode","practice"));
    }
}
