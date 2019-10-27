package com.km.WeeklyContest160;

import java.util.ArrayList;
import java.util.List;

public class Find_Positive_Integer_Solution_for_a_Given_Equation {
    class CustomFunction {
        public int f(int x, int y) {
            return 0;
        }
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                int res = customfunction.f(i, j);
                if(res == z){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    ans.add(cur);
                }
            }
        }
        return ans;
    }
}
