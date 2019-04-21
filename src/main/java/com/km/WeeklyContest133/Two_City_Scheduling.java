package com.km.WeeklyContest133;

import java.util.Arrays;
import java.util.Comparator;

public class Two_City_Scheduling {
    public int twoCitySchedCost(int[][] costs) {
        int ans = 0;
        int[][] diff = new int[costs.length][2];
        for(int i = 0;i<costs.length;i++){
            diff[i][0] = i;
            diff[i][1] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(diff, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int i = 0;i<costs.length;i++){
            if(i<costs.length/2)
                ans+=costs[diff[i][0]][0];
            else
                ans+=costs[diff[i][0]][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        Two_City_Scheduling test = new Two_City_Scheduling();
        test.twoCitySchedCost(costs);
    }
}
