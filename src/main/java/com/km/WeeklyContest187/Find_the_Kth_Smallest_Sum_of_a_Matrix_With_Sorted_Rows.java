package com.km.WeeklyContest187;

import java.util.PriorityQueue;

public class Find_the_Kth_Smallest_Sum_of_a_Matrix_With_Sorted_Rows {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        for(int i = 0;i<mat[0].length;i++){
            queue.add(mat[0][i]);
            if(queue.size()>k)
                queue.poll();
        }
        for(int i = 1;i<mat.length;i++){
            PriorityQueue<Integer> nextQueue = new PriorityQueue<>((a,b)->(b-a));
            for(int num:queue){
                for(int j = 0;j<mat[0].length;j++){
                    nextQueue.add(num+mat[i][j]);
                    if(nextQueue.size()>k)
                        nextQueue.poll();
                }
            }
            queue = nextQueue;
        }
        return queue.poll();
    }
}
