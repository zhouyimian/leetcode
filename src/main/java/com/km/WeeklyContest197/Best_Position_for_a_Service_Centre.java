package com.km.WeeklyContest197;

public class Best_Position_for_a_Service_Centre {
    public double getMinDistSum(int[][] positions) {
        double min = Double.MAX_VALUE;
        double x = 50, y=50, delta = 50;
        double min_x=x, min_y=y;

        while(delta >= 10e-4){
            for(double i= x-delta; i<=x+delta; i+=delta/100){
                for(double j= y-delta; j<=y+delta; j+=delta/100){
                    double d = dist(positions,i,j);
                    if(d<=min){
                        min = d;
                        min_x = i;
                        min_y = j;
                    }
                }
            }
            x=min_x;
            y=min_y;
            delta /=100;
        }
        return min;
    }

    private double dist(int[][] positions, double x, double y){
        double ans = 0;

        for(int[] p: positions){
            double d = Math.pow(p[0]-x,2) + Math.pow(p[1]-y,2);
            ans += Math.sqrt(d);
        }

        return ans;
    }
}
