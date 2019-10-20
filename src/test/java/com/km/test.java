package com.km;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];
        for(int i = 0;i<n;i++)
            times[i] = sc.nextInt();
        Arrays.sort(times);
        int ans = 0;
        for(int i = 0;i<n;i++)
            ans+=times[i];
        System.out.println(ans);
    }
}
