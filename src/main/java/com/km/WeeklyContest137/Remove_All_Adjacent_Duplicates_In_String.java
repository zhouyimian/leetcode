package com.km.WeeklyContest137;

import java.util.Stack;

public class Remove_All_Adjacent_Duplicates_In_String {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<S.length();){
            if(stack.size()==0||stack.peek()!=S.charAt(i))
                stack.push(S.charAt(i++));
            else{
                stack.pop();
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c:stack)
            sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        Remove_All_Adjacent_Duplicates_In_String test = new Remove_All_Adjacent_Duplicates_In_String();
        System.out.println(test.removeDuplicates("aaaaaaaaa"));
    }
}
