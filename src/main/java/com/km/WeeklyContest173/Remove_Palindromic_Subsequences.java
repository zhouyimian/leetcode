package com.km.WeeklyContest173;

import java.util.Arrays;

public class Remove_Palindromic_Subsequences {
    public int removePalindromeSub(String s) {
        return s.isEmpty() ? 0 : (s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2);
    }
}
