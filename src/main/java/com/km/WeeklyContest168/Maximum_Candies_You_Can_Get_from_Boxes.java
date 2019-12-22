package com.km.WeeklyContest168;

import java.util.*;

public class Maximum_Candies_You_Can_Get_from_Boxes {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        List<Integer> queue = new ArrayList<>();
        boolean[] canvisit = new boolean[candies.length];
        boolean[] cantake = new boolean[candies.length];
        boolean[] visit = new boolean[candies.length];
        for (int num : initialBoxes) {
            canvisit[num] = true;
            if (status[num] == 1) {
                queue.add(num);
                cantake[num] = true;
            }
        }
        while (queue.size() != 0) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                int start = queue.get(i);
                if(!visit[start]) {
                    visit[start] = true;
                    for (int j = 0; j < containedBoxes[start].length; j++) {
                        canvisit[containedBoxes[start][j]] = true;
                        if (status[containedBoxes[start][j]] == 1 && !visit[containedBoxes[start][j]]) {
                            temp.add(containedBoxes[start][j]);
                            cantake[containedBoxes[start][j]] = true;
                        }
                    }
                    for (int j = 0; j < keys[start].length; j++) {
                        status[keys[start][j]] = 1;
                        if (canvisit[keys[start][j]] && !visit[keys[start][j]]) {
                            temp.add(keys[start][j]);
                            cantake[keys[start][j]] = true;
                        }
                    }
                }
            }
            queue.clear();
            queue.addAll(temp);
        }
        for (int i = 0; i < status.length; i++) {
            if (cantake[i]) {
                ans += candies[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Maximum_Candies_You_Can_Get_from_Boxes test = new Maximum_Candies_You_Can_Get_from_Boxes();
        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = {{}, {}, {1}, {}};
        int[][] indexs = {{1, 2}, {3}, {}, {}};
        int[] start = {0};
        System.out.println(test.maxCandies(status, candies, keys, indexs, start));
    }
}
