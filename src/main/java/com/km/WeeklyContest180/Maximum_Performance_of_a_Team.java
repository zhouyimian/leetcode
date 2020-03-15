package com.km.WeeklyContest180;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximum_Performance_of_a_Team {
    int MOD = 1000000007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for(int i = 0;i<n;i++)
            engineers[i] = new int[] {efficiency[i],speed[i]};
        Arrays.sort(engineers,(a,b)->b[0]-a[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,(a,b)->a-b);
        long res = Long.MIN_VALUE,totalSpeed = 0;
        for(int[] engineer:engineers){
            if(queue.size()==k) totalSpeed-=queue.poll();
            queue.add(engineer[1]);
            totalSpeed+=engineer[1];
            res = Math.max(res,(totalSpeed*engineer[0]));
        }

        return (int) (res%MOD);
    }

    public static void main(String[] args) {
        Maximum_Performance_of_a_Team test = new Maximum_Performance_of_a_Team();
        int[] effect = {2,10,3,1,5,8};
        int[] speed = {5,4,3,9,7,2};
        System.out.println(test.maxPerformance(6,effect,speed,4));
        System.out.println(test);
    }
}
