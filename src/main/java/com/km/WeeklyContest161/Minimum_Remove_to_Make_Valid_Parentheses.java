package com.km.WeeklyContest161;

import java.util.Stack;

public class Minimum_Remove_to_Make_Valid_Parentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(sb.charAt(i)=='(') stack.push(i);
            else if(sb.charAt(i)==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    sb.setCharAt(i,'*');
                }
            }
        }
        while (!stack.isEmpty()){
            sb.setCharAt(stack.pop(),'*');
        }
        return sb.toString().replaceAll("\\*","");
    }
}
