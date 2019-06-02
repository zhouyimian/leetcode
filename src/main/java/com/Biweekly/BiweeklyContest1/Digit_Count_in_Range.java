package com.Biweekly.BiweeklyContest1;

public class Digit_Count_in_Range {
    public int digitsCount(int d, int low, int high) {
        int left = deal(low-1,d);
        int right = deal(high,d);
        return right-left;
    }
    public int deal(int n,int x){
        int cnt = 0, k;
        for (int i = 1;(k = n / i)!=0;i *= 10) {
            int high = k / 10;
            if (x == 0) {
                if (high!=0) {
                    high--;
                } else {
                    break;
                }
            }
            cnt += high * i;
            // 当前位的数字。
            int cur = k % 10;
            if (cur > x) {
                cnt += i;
            } else if (cur == x) {
                // n - k * i 为低位的数字。
                cnt += n - k * i + 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Digit_Count_in_Range test = new Digit_Count_in_Range();
        System.out.println(test.digitsCount(0,1,10));
    }
}
