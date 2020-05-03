package com.Biweekly.BiweeklyContest24;

import java.util.TreeSet;

public class Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K {
    public int findMinFibonacciNumbers(int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int a = 1;
        int b = 1;
        set.add(1);
        while ((a+b)<=k){
            set.add(a+b);
            int temp = a;
            a = b;
            b+=temp;
        }
        int ans = 0;
        while (k!=0){
            int num = set.floor(k);
            ans++;
            k-=num;
        }
        return ans;
    }
}
