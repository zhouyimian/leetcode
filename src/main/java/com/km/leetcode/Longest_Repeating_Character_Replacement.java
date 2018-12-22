package com.km.leetcode;

public class Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i <= k)
                ans = Math.max(ans, i);
            else {
                int start = i - 1;
                int temp_k = k;
                int temp_i = i + 1;
                while (start >= 0) {
                    if (s.charAt(start) != s.charAt(i)) {
                        if (temp_k > 0)
                            temp_k--;
                        else
                            break;
                    }
                    start--;
                }
                ans = Math.max(ans, i - start);
                if (start == -1 && temp_k > 0) {
                    while (temp_i < s.length()) {
                        if (s.charAt(temp_i) != s.charAt(i)) {
                            if (temp_k > 0)
                                temp_k--;
                            else
                                break;
                        }
                        temp_i++;
                    }
                    ans = Math.max(ans, temp_i - start - 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Longest_Repeating_Character_Replacement test = new Longest_Repeating_Character_Replacement();
        System.out.println(test.characterReplacement("BAAAB", 2));
    }
}
