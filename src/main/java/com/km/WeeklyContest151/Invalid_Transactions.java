package com.km.WeeklyContest151;

import java.util.*;

public class Invalid_Transactions {
    public List<String> invalidTransactions(String[] transactions) {
        int len = transactions.length;
        String[][] all = new String[len][4];
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < len; i++) {
            all[i] = transactions[i].split(",");
        }
        Arrays.sort(all, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].compareTo(o2[0]) == 0) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (all[j][0].equals(all[i][0]) && !all[j][3].equals(all[i][3])) {
                    if (Math.abs(Integer.parseInt(all[i][1]) - Integer.parseInt(all[j][1])) <= 60) {
                        ans.add(all[j][0] + "," + all[j][1] + "," + all[j][2] + "," + all[j][3]);
                        ans.add(all[i][0] + "," + all[i][1] + "," + all[i][2] + "," + all[i][3]);
                    }
                }
            }
            if (Integer.parseInt(all[i][2]) > 1000) {
                ans.add(all[i][0] + "," + all[i][1] + "," + all[i][2] + "," + all[i][3]);
            }
        }
        return new ArrayList<>(ans);
    }
}
