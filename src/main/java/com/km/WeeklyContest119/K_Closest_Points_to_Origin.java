package com.km.WeeklyContest119;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans=new int[K][2];
        Queue<int[]> queue=new PriorityQueue<>(points.length,new Comparator<int[]>() {
            @Override
            public int compare(int[] nums1, int[] nums2) {
                double res=Math.pow(nums1[0],2)+Math.pow(nums1[1],2)-Math.pow(nums2[0],2)-Math.pow(nums2[1],2);
                if(res>0) return 1;
                else if(res<0) return -1;
                return 0;
            }
        });
        for(int i=0;i<points.length;i++)
            queue.add(points[i]);
        for(int i=0;i<K;i++){
            int[] temp=queue.poll();
            ans[i][0]=temp[0];
            ans[i][1]=temp[1];
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
