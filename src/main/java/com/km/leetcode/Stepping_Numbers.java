package com.km.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Stepping_Numbers {
    public ArrayList<Integer> countSteppingNumbers(int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        if (low > high) return res;

        Queue<Long> queue = new LinkedList<>();
        for (long i = 1; i <= 9; i++) queue.add(i);

        if (low == 0) res.add(0);
        while (!queue.isEmpty()) {
            long p = queue.poll();
            if (p < high) {
                long last = p % 10;
                if (last > 0) queue.add(p * 10 + last - 1);
                if (last < 9) queue.add(p * 10 + last + 1);
            }
            if (p >= low && p <= high) {
                res.add((int) p);
            }
        }
        return res;
    }
}
