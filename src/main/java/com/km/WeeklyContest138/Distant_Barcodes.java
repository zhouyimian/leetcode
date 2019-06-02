package com.km.WeeklyContest138;

import java.util.*;

public class Distant_Barcodes {
    class Num{
        int num;
        int count;
        public Num(int num,int count){
            this.num = num;
            this.count = count;
        }
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:barcodes)
            map.put(num,map.getOrDefault(num,0)+1);
        PriorityQueue<Num> queue = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o2.count-o1.count;
            }
        });
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value= entry.getValue();
            Num num = new Num(key,value);
            queue.add(num);
        }
        int index = 0;
        while(queue.size()!=0){
            Num num1 = queue.poll();
            Num num2 = queue.poll();
            if(num1!=null) {
                barcodes[index++] = num1.num;
                num1.count--;
                if(num1.count!=0)
                    queue.add(num1);
            }
            if(num2!=null) {
                barcodes[index++] = num2.num;
                num2.count--;
                if(num2.count!=0)
                    queue.add(num2);
            }
        }
        return barcodes;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2};
        Distant_Barcodes test = new Distant_Barcodes();
        int[] result = test.rearrangeBarcodes(nums);
        for(int num:result){
            System.out.println(num);
        }
    }
}
