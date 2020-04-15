package com.Biweekly.BiweeklyContest23;

import java.util.*;

public class Reducing_Dishes {
    public int maxSatisfaction(int[] satisfaction) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int postiveSum = 0;
        for(int num:satisfaction){
            if(num<0)
                negative.add(num);
            else {
                postiveSum+=num;
                positive.add(num);
            }
        }
        Collections.sort(positive);
        Collections.sort(negative);
        for(int i = 0;i<negative.size();i++){
            int cost = 0;
            for(int j = i;j<negative.size();j++){
                cost+=negative.get(j);
            }
            if(cost+postiveSum<0){
                negative.remove(i);
                i--;
            }
        }
        int ans = 0;
        int nowTime = 1;
        for(int num:negative){
            ans+=num*nowTime;
            nowTime++;
        }
        for(int num:positive){
            ans+=num*nowTime;
            nowTime++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Reducing_Dishes test = new Reducing_Dishes();
        int[] nums = {-1,-8,0,5,-9};
        System.out.println(test.maxSatisfaction(nums));
    }
}
