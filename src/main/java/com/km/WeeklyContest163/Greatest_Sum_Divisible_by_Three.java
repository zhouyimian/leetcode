package com.km.WeeklyContest163;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Greatest_Sum_Divisible_by_Three {
    public int maxSumDivThree(int[] nums) {
        int ans = 0;
        PriorityQueue<Integer> divide1 = new PriorityQueue<>();
        PriorityQueue<Integer> divide2 = new PriorityQueue<>();
        for(int num:nums){
            ans+=num;
            if(num%3==1)
                divide1.add(num);
            if(num%3==2)
                divide2.add(num);
        }
        if(ans%3==0)
            return ans;
        else if(ans%3==1){
            int temp = ans;
            if(divide1.size()>=1)
                temp-=divide1.poll();
            if(divide2.size()>=2)
                temp = Math.max(temp,ans-divide2.poll()-divide2.poll());
            return temp;
        }else{
            int temp = ans;
            if(divide2.size()>=1)
                temp-=divide2.poll();
            if(divide1.size()>=2)
                temp = Math.max(temp,ans-divide1.poll()-divide1.poll());
            return temp;
        }
    }

    public static void main(String[] args) {
        Greatest_Sum_Divisible_by_Three tese = new Greatest_Sum_Divisible_by_Three();
        int[] nums = {1,2,3,4,4};
        System.out.println(tese.maxSumDivThree(nums));
    }
}
