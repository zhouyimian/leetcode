package com.km.WeeklyContest145;

import java.util.HashMap;
import java.util.Map;

public class Longest_Well_Performing_Interval {
    public int longestWPI(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; ++i) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6,9,6};
        Longest_Well_Performing_Interval test = new Longest_Well_Performing_Interval();
        System.out.println(test.longestWPI(nums));
    }
}
