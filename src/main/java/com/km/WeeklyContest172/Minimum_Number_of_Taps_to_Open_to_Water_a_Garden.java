package com.km.WeeklyContest172;

import java.util.*;

public class Minimum_Number_of_Taps_to_Open_to_Water_a_Garden {
    public int minTaps(int n, int[] ranges) {
        boolean[] remove = new boolean[ranges.length];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j || remove[j] || remove[i])
                    continue;
                if (cover(i, ranges[i], j, ranges[j],n)) {
                    remove[i] = true;
                }
            }
        }
        List<Integer[]> canUse = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (!remove[i]) {
                Integer[] range = new Integer[2];
                range[0] = i - ranges[i] < 0 ? 0 : i - ranges[i];
                range[1] = i + ranges[i]>=n?n:i+ranges[i];
                canUse.add(range);
            }
        }
        if (canUse.get(0)[0] > 0 || canUse.get(canUse.size() - 1)[1] < n)
            return -1;
        if(canUse.size()==1)
            return 1;
        int ans = 1;
        int start = 0;
        while (true) {
            int maxNext = canUse.get(start)[1];
            int nextStart = -1;
            boolean isfind = false;
            for (int j = start + 1; j < canUse.size(); j++) {
                if (canUse.get(j)[0] <= canUse.get(start)[1] && canUse.get(j)[1] >= maxNext) {
                    nextStart = j;
                    maxNext = canUse.get(j)[1];
                    isfind = true;
                } else {
                    break;
                }
            }
            if (!isfind) {
                return -1;
            }
            ans++;
            if (maxNext >= n)
                break;
            else
                start = nextStart;
        }
        return ans;
    }

    private boolean cover(int first, int firstRange, int second, int secondRange,int maxRange) {
        int firstStart = first - firstRange < 0 ? 0 : first - firstRange;
        int firstEnd = first + firstRange>=maxRange?maxRange:first + firstRange;
        int secondStart = second - secondRange < 0 ? 0 : second - secondRange;
        int secondEnd = second + secondRange>=maxRange?maxRange:second + secondRange;
        if (firstStart >= secondStart && firstEnd <= secondEnd)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Minimum_Number_of_Taps_to_Open_to_Water_a_Garden test = new Minimum_Number_of_Taps_to_Open_to_Water_a_Garden();
        int[] ranges = {4,0,0,0,4,0,0,0,4};
        System.out.println(test.minTaps(8, ranges));
    }
}
