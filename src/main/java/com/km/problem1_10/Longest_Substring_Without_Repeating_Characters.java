package com.km.problem1_10;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "eeydgwdykpv";
        Longest_Substring_Without_Repeating_Characters test = new Longest_Substring_Without_Repeating_Characters();
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
