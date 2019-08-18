package com.km.WeeklyContest150;

import java.util.Arrays;

public class Find_Words_That_Can_Be_Formed_by_Characters {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;

        for(String s:words){
            int[] count = new int[26];
            for(int i = 0;i<chars.length();i++)
                count[chars.charAt(i)-'a']++;
            if(deal(s,count))
                ans+=s.length();
        }
        return ans;
    }

    private boolean deal(String s, int[] count) {
        for(int i = 0;i<s.length();i++){
            if(--count[s.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }
}
