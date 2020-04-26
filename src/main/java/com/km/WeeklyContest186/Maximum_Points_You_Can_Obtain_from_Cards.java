package com.km.WeeklyContest186;

public class Maximum_Points_You_Can_Obtain_from_Cards {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        int sum = 0;
        int length = cardPoints.length;
        for(int i = 0;i<k;i++)
            sum+=cardPoints[i];
        if(k==length)
            return sum;
        ans = sum;
        for(int i = 1;i<=k;i++){
            sum = sum+cardPoints[length-i]-cardPoints[k-i];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
