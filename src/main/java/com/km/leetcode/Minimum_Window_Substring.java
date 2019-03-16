package com.km.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<t.length();i++)
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        String ans = "";
        int left = 0,count = 0,minlength = Integer.MAX_VALUE;
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))>=0)
                    count++;
            }
            while(count==t.length()){
                if(minlength>i-left+1){
                    minlength = i-left+1;
                    ans = s.substring(left,left+minlength);
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left))>0)
                        count--;
                }
                left++;
            }
        }
        return minlength==Integer.MAX_VALUE?"":ans;
    }

    public static void main(String[] args) {
        Minimum_Window_Substring test = new Minimum_Window_Substring();
        System.out.println(test.minWindow("ADOBECODEBANC","ABC"));
    }
}
