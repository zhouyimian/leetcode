package com.km.leetcode;

import java.util.*;

public class Largest_Number {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int num:nums)
            list.add(num+"");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
        });
        if(list.get(0).charAt(0)=='0')
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String s:list)
            sb.append(s);
        return sb.toString();
    }
}
