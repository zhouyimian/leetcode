package com.km.WeeklyContest203;

import java.util.Arrays;

public class Maximum_Number_of_Coins_You_Can_Get {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int lowIndex = 0;
        int lastIndex = piles.length-1;
        while (lowIndex<lastIndex){
            lowIndex++;
            ans+=piles[lastIndex-1];
            lastIndex-=2;
        }
        return ans;
    }
}
