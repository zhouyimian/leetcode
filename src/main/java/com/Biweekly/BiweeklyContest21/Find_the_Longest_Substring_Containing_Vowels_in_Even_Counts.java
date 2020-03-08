package com.Biweekly.BiweeklyContest21;

import java.util.HashMap;
import java.util.HashSet;

public class Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts {
    HashMap<Character, Integer> voewlToIndex = new HashMap<Character, Integer>() {
        {
            put('a', 0);
            put('e', 1);
            put('i', 2);
            put('o', 3);
            put('u', 4);
        }
    };
    public int findTheLongestSubstring(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        map.put(0,-1);
        int cur = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(voewlToIndex.containsKey(c)){
                cur^=(1<<voewlToIndex.get(c));
            }
            map.putIfAbsent(cur,i);
            ans = Math.max(ans,i-map.get(cur));
        }
        return ans;

    }
}
