package com.km.WeeklyContest160;

import java.util.ArrayList;
import java.util.List;

public class Circular_Permutation_in_Binary_Representation {
    public List<Integer> circularPermutation(int n, int start) {
        int size = (int) Math.pow(2, n);
        List<Integer> list = new ArrayList<>(size);
        int more = 1;
        list.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(more + list.get(j));
            }
            more <<= 1;
        }
        int index = list.indexOf(start);
        List<Integer> ans = new ArrayList<>(size);
        for (int i = index; i < size; i++) {
            ans.add(list.get(i));
        }
        for (int i = 0; i < index; i++) {
            ans.add(list.get(i));
        }
        return ans;
    }
}
