package com.km.problem1_10;

public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        boolean ans = false;
        StringBuilder before = new StringBuilder(x+"");
        StringBuilder after = before.reverse();
        before = new StringBuilder(x+"");
        return before.toString().equals(after.toString());
    }

    public static void main(String[] args) {
        Palindrome_Number test = new Palindrome_Number();
        System.out.println(test.isPalindrome(121));
    }
}
