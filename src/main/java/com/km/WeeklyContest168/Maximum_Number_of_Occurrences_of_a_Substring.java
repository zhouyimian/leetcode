package com.km.WeeklyContest168;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Maximum_Number_of_Occurrences_of_a_Substring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        for(int size = minSize;size<=maxSize;size++){
            ans = Math.max(ans,deal(s,maxLetters,size));
        }
        return ans;
    }

    private int deal(String s, int maxLetters, int size) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i<=s.length()-size;i++){
            String substring = s.substring(i,i+size);
            Set<Character> set = new HashSet<>();
            for(int j = 0;j<substring.length();j++){
                set.add(substring.charAt(j));
                if(set.size()>maxLetters)
                    break;
            }
            if(set.size()<=maxLetters){
                map.put(substring,map.getOrDefault(substring,0)+1);
            }
        }
        int max = 0;
        for(String key:map.keySet())
            max = Math.max(max,map.get(key));
        return max;
    }

    public static void main(String[] args) {
        Maximum_Number_of_Occurrences_of_a_Substring test = new Maximum_Number_of_Occurrences_of_a_Substring();
        String s = "aababcaab";
        int maxletters = 2;
        int min = 3;
        int max = 4;
        System.out.println(test.maxFreq(s, maxletters, min, max));
    }
}
//""
//2
//3
//4