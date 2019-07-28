package com.km.WeeklyContest147;

public class N_th_Tribonacci_Number {
    public int tribonacci(int n) {
        int[] t = new int[38];
        t[1] = 1;
        t[2] = 1;
        if(n<=2)
            return t[n];
        for(int i = 3;i<=n;i++){
            t[i] = t[i-1]+t[i-2]+t[i-3];
        }
        return t[n];
    }

    public static void main(String[] args) {
        N_th_Tribonacci_Number test = new N_th_Tribonacci_Number();
        System.out.println(test.tribonacci(0));
    }
}
