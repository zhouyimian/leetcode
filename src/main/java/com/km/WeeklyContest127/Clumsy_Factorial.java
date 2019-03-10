package com.km.WeeklyContest127;

public class Clumsy_Factorial {
    public int clumsy(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 6;
        if (N == 4) return 7;
        return N * (N - 1) / (N - 2) + N - 3 + helper(N - 4);
        }
    public int helper(int N) {
        if (N == 0) return 0;
        if (N == 1) return -1;
        if (N == 2) return -2;
        if (N == 3) return -6;
        if (N == 4) return -5;
        return -N * (N - 1) / (N - 2) + N - 3 + helper(N - 4);
    }

    public static void main(String[] args) {

    }
}
