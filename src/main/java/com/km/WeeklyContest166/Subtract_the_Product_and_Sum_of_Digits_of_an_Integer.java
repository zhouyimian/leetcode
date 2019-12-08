package com.km.WeeklyContest166;

public class Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
    public int subtractProductAndSum(int n) {
        int ji = 1;
        int he = 0;
        while(n>0){
            ji *= n  % 10;
            he += n % 10;
            n/=10;
        }
        return ji-he;
    }
}
