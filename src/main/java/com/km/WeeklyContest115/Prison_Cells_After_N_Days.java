package com.km.WeeklyContest115;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prison_Cells_After_N_Days {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[8];
            map.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
            if (map.containsKey(Arrays.toString(cells))) {
                N %= map.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;
    }

    public static void main(String[] args) {
        Prison_Cells_After_N_Days test=new Prison_Cells_After_N_Days();
        int[] nums={0,1,0,1,1,0,0,1};
        int[] ans= test.prisonAfterNDays(nums,1);
        for(int num:ans)
            System.out.print(num+" ");
    }
}
