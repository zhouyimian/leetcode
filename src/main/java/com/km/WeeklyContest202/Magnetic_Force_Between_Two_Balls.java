package com.km.WeeklyContest202;

import java.util.Arrays;

public class Magnetic_Force_Between_Two_Balls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 0;
        int high = position[position.length-1];
        int ans = -1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(canput(position,m,mid)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    private boolean canput(int[] position, int m, int distinct) {
        int count = 1;
        int last = position[0];
        for(int i = 1;i<position.length;i++){
            if(position[i]-last>=distinct){
                count++;
                last = position[i];
            }
        }
        return count>=m;
    }
}
