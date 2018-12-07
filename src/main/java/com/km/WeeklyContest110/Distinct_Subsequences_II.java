package com.km.WeeklyContest110;

import java.util.Arrays;

public class Distinct_Subsequences_II {
    public int distinctSubseqII(String S) {
        long ans = 0;
        long mod=(long)1e9 + 7;
        long[] end = new long[26];
        for (char c : S.toCharArray())
            end[c - 'a'] = Arrays.stream(end).sum() % mod + 1;
        return (int)(Arrays.stream(end).sum() % mod);
    }

    public static void main(String[] args) {
        Distinct_Subsequences_II test=new Distinct_Subsequences_II();
        System.out.println(test.distinctSubseqII("abdae"));
    }
}
