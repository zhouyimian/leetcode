package com.Biweekly.BiweeklyContest21;

import java.util.TreeMap;

public class Increasing_Decreasing_String {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while (sb.length()!=s.length()){

        }
        return sb.toString();
    }
}
