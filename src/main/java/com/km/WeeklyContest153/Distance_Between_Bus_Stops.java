package com.km.WeeklyContest153;

public class Distance_Between_Bus_Stops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start>=destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        int ans = 0;
        int ans2 = 0;
        for(int i = start;i<destination;i++){
            ans+=distance[i];
        }
        for(int i = destination;i<distance.length;i++){
            ans2+=distance[i];
        }
        for(int i = 0;i<start;i++){
            ans2+=distance[i];
        }
        return Math.min(ans,ans2);
    }
}
