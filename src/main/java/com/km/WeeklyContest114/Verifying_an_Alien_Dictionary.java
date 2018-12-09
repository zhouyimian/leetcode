package com.km.WeeklyContest114;

import java.util.HashMap;
import java.util.Map;

public class Verifying_an_Alien_Dictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<26;i++)
            map.put(order.charAt(i),i);
        for(int i=0;i<words.length-1;i++){
            if(compare(words[i],words[i+1],map)== false)
                return false;
        }
        return true;
    }

    private boolean compare(String s1, String s2, Map<Character, Integer> map) {
        int i,j;
        for(i=0,j=0;i<s1.length()&&j<s2.length();i++,j++){
            if(s1.charAt(i)==s2.charAt(j))
                continue;
            else{
                int num1=map.get(s1.charAt(i));
                int num2=map.get(s2.charAt(j));
                return num1<num2;
            }
        }
        if(i==s1.length()&&j==s2.length())
            return true;
        return i==s1.length();
    }
}
