package com.km.WeeklyContest201;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target {
    public int maxNonOverlapping(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int res = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
        }

        return res;
    }

    public static void main(String[] args) {
        Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target test = new Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target();
        int[] nums = {0,0,0};
        System.out.println(test.maxNonOverlapping(nums,0));
    }
}
