package com.km.WeeklyContest176;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    List<Integer> nums = new ArrayList<>();
    public ProductOfNumbers() {
        nums.add(1);
    }

    public void add(int num) {
        if (num > 0)
            nums.add(nums.get(nums.size() - 1) * num);
        else {
            nums.clear();
            nums.add(1);
        }
    }

    public int getProduct(int k) {
        int n = nums.size();
        return k < n ? nums.get(n - 1) /nums.get(n - k - 1)  : 0;
    }
}
