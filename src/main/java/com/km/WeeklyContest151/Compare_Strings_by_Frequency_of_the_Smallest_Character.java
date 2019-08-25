package com.km.WeeklyContest151;

import java.util.*;

public class Compare_Strings_by_Frequency_of_the_Smallest_Character {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] que = cal(queries);
        int[] wordque = cal(words);
        for(int i = 0;i<queries.length;i++){
            int count = 0;
            for(int num:wordque){
                if(num>que[i])
                    count++;
            }
            ans[i] = count;
        }
        return ans;
    }

    private int[] cal(String[] queries) {
        int[] res = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            char[] temp = queries[i].toCharArray();
            Arrays.sort(temp);
            int j;
            for(j = 1;j<temp.length;j++) {
                if (temp[j] != temp[j - 1])
                    break;
            }
            res[i] = j;
        }
        return res;
    }

}
//["alex,676,260,bangkok","bob,656,1366,bangkok","alex,393,616,bangkok","bob,820,990,amsterdam","alex,596,1390,amsterdam"]