package com.km.WeeklyContest162;

import java.util.Map;

public class Maximum_Score_Words_Formed_by_Letters {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[score.length];
        for(char c:letters)
            count[c-'a']++;
        return dfs(words,score,count,0);
    }

    private int dfs(String[] words, int[] score, int[] count,int index) {
        int max = 0;
        for(int i = index;i<words.length;i++){
            int res = 0;
            boolean isValid = true;
            for(char c:words[i].toCharArray()){
                res+=score[c-'a'];
                count[c-'a']--;
                if(count[c-'a']<0){
                    isValid=false;
                }
            }
            if(isValid){
                res+=dfs(words,score,count,i+1);
                max = Math.max(max,res);
            }
            for(char c:words[i].toCharArray()){
                count[c-'a']++;
                res = 0;
            }
        }
        return max;
    }
}
