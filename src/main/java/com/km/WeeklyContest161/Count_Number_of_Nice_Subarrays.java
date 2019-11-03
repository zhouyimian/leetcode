package com.km.WeeklyContest161;

import java.util.HashMap;
import java.util.Map;

public class Count_Number_of_Nice_Subarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] a, int k) {
        int first = 0, ans = 0, count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1)
                count++;
            while (count > k) {
                if (a[first] % 2 == 1) {
                    count--;
                }
                first++;
            }
            ans += (i - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Count_Number_of_Nice_Subarrays t = new Count_Number_of_Nice_Subarrays();
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(t.numberOfSubarrays(nums, 2));
    }
}
