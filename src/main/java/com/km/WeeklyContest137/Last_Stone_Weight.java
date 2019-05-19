package com.km.WeeklyContest137;

import java.util.PriorityQueue;

public class Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        int length = stones.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int num:stones)
            queue.add(num);
        while(queue.size()>1){
            int num1 = queue.poll();
            int num2 = queue.poll();
            if(num1!=num2)
                queue.add(num1-num2);
        }
        return queue.size()==1?queue.poll():0;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        Last_Stone_Weight test = new Last_Stone_Weight();
        System.out.println(test.lastStoneWeight(nums));
    }
}
