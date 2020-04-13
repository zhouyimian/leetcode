package com.km.WeeklyContest184;

import java.util.ArrayList;
import java.util.List;

public class String_Matching_in_an_Array {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int length = words.length;
        for(int i = 0;i<length;i++){
            for(int j = 0;j<length;j++){
                if(i==j) continue;
                else{
                    if(words[j].contains(words[i])){
                        ans.add(words[i]);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
