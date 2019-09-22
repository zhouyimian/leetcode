package com.km.WeeklyContest155;

public class Ugly_Number_III {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1,high = Integer.MAX_VALUE,mid;
        while (low<high){
            mid = low+(high-low)/2;
            if(divTermCount(a,b,c,mid)<n)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }

    private long divTermCount(int a, int b, int c, int num) {
        return (num/a)+(num/b)+(num/c)-(num/lcm(a,b))-(num/lcm(a,c))-(num/lcm(b,c))+(num/lcm(a,lcm(b,c)));
    }

    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    public long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}
