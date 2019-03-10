package com.km.WeeklyContest126;

import java.util.ArrayList;
import java.util.List;

public class Find_Common_Characters {
    public List<String> commonChars(String[] A) {
        int[][] counts = new int[A.length][26];
        List<String> ans = new ArrayList<>();
        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<A[i].length();j++){
                counts[i][A[i].charAt(j)-'a']++;
            }
        }
        for(int i = 0;i<26;i++){
            int time = cal(i,counts);
            for(int j = 0;j<time;j++){
                Character c = (char)(i + 'a');
                ans.add(new String(c+""));
            }

        }
        return ans;
    }
    public int cal(int index,int[][] counts){
        int time=Integer.MAX_VALUE;
        for(int i = 0;i<counts.length;i++){
            time = Math.min(time,counts[i][index]);
        }
        return time;
    }
}
