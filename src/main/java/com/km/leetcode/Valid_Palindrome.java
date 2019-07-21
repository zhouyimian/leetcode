package com.km.leetcode;

public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals(""))
            return true;
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(int i = 0;i<s.length();i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
        }
        for (int i = 0, j = sb.length() - 1; i <= j; i++, j--) {
            if (sb.charAt(i) != sb.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Valid_Palindrome test = new Valid_Palindrome();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
