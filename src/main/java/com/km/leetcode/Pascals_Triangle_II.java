package com.km.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if (rowIndex == 0) {
            ans = Arrays.asList(1);
        } else if (rowIndex == 1) {
            ans = Arrays.asList(1, 1);
        } else {
            ans = Arrays.asList(1,1);
            for (int i = 2; i <= rowIndex; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        temp.add(1);
                    } else {
                        temp.add(ans.get(j-1)+ans.get(j));
                    }
                }
                ans = new ArrayList<>();
                ans.addAll(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Pascals_Triangle_II test = new Pascals_Triangle_II();
        System.out.println(test.getRow(5));
    }
}
