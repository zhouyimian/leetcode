package com.km.WeeklyContest174;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Reduce_Array_Size_to_The_Half {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1]-o1[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            queue.add(new Integer[]{num,count});
        }
        int ans = 0;
        int count = 0;
        while (count<arr.length/2&&!queue.isEmpty()){
            count+=queue.poll()[1];
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Reduce_Array_Size_to_The_Half test = new Reduce_Array_Size_to_The_Half();
        int[] arr  = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(test.minSetSize(arr));
    }
}
