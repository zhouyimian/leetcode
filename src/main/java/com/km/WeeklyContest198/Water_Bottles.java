package com.km.WeeklyContest198;

public class Water_Bottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;
        while(numBottles+empty>=numExchange){
            ans+=numBottles;
            empty+=numBottles;
            numBottles=empty/numExchange;
            empty%=numExchange;
        }
        return ans+numBottles;
    }

    public static void main(String[] args) {
        Water_Bottles test = new Water_Bottles();
        System.out.println(test.numWaterBottles(5,5));
    }
}
