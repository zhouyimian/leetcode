package com.km.WeeklyContest157;

public class Play_with_Chips {
    public int minCostToMoveChips(int[] chips) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<chips.length;i++){
            int temp = 0;
            for(int j = 0;j<chips.length;j++){
                if(j==i)
                    continue;
                else{
                    temp+=Math.abs(chips[j]-chips[i])%2;
                }
            }
            ans = Math.min(ans,temp);
        }
        return ans;
    }
}
