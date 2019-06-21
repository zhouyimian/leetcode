package com.km.WeeklyContest140;

import java.util.ArrayList;
import java.util.List;

public class Occurrences_After_Bigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> anslist = new ArrayList<>();
        for(int i = 0;i<words.length-1;i++){
            String one = words[i];
            String two = words[i+1];
            if(one.equals(first)&&two.equals(second)&&i+2<words.length)
                anslist.add(words[i+2]);
        }
        String[] ans = new String[anslist.size()];
        for(int i = 0;i<anslist.size();i++){
            ans[i] = anslist.get(i);
        }
        return ans;
    }
}
