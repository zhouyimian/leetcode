package com.Biweekly.BiweeklyContest21;

import java.util.Comparator;
import java.util.TreeMap;

public class Increasing_Decreasing_String {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        while (sb.length()!=s.length()){
            for(int i = 0;i<26;i++){
                if(count[i]!=0){
                    sb.append((char)(i+'a'));
                    count[i]--;
                }
            }
            for(int i = 25;i>=0;i--){
                if(count[i]!=0){
                    sb.append((char)(i+'a'));
                    count[i]--;
                }
            }
        }
        return sb.toString();
    }
}
