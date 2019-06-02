package com.Biweekly.BiweeklyContest1;

import java.util.HashSet;
import java.util.Set;

public class Index_Pairs_of_a_String {
    public int[][] indexPairs(String text, String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words)
            set.add(word);
        int count = 0;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            for (int j = i ; j < length; j++) {
                if (set.contains(text.substring(i, j + 1)))
                    count++;
            }
        }
        int[][] ans = new int[count][2];
        int index = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i ; j < length; j++) {
                if (set.contains(text.substring(i, j + 1))) {
                    ans[index][0] = i;
                    ans[index][1] = j;
                    index++;
                }
            }
        }
        return ans;
    }
}
