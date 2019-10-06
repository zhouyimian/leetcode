package com.km.leetcode;

public class Valid_Palindrome_III {
    public boolean isValidPalindrome(String s, int k) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return aux(dp,0,s.length()-1,s)<=k;
    }

    private int aux(Integer[][] dp, int left, int right,String s) {
        if(left>=right)
            return 0;
        if(dp[left][right]!=null)
            return dp[left][right];
        int step = 0;
        if(s.charAt(left)==s.charAt(right)){
            step = aux(dp,left+1,right-1,s);
        }else{
            step = Math.min(aux(dp, left+1, right, s), aux(dp, left, right-1, s))+1;
        }
        dp[left][right] = step;
        return step;
    }

    public static void main(String[] args) {
        Valid_Palindrome_III test = new Valid_Palindrome_III();
        System.out.println(test.isValidPalindrome("bacabaaa",2));
    }
}
//"bacabaaa"
//2