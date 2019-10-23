package com.km.WeeklyContest159;

public class Replace_the_Substring_for_Balanced_String {
    public int balancedString(String s) {
        int[] count = new int[128];
        int n = s.length(), res = n, i = 0;
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j)];
        }
        for (int j = 0; j < n; ++j) {
            --count[s.charAt(j)];
            while (i < n && count['Q'] <= n / 4 && count['W'] <= n / 4 && count['E'] <= n / 4 && count['R'] <= n / 4) {
                res = Math.min(res, j - i + 1);
                ++count[s.charAt(i++)];
            }
        }
        return res;
    }
}
