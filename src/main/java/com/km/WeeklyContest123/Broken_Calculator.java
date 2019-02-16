package com.km.WeeklyContest123;

public class Broken_Calculator {
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while(Y>X){
            Y = Y%2>0?Y+1:Y/2;
            ans++;
        }
        return ans+X - Y;
    }
}
