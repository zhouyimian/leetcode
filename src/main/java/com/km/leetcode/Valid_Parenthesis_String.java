package com.km.leetcode;

import java.util.Stack;

public class Valid_Parenthesis_String {
    public boolean checkValidString(String s) {
        Stack<Character> stack=new Stack<>(),tempstack=new Stack<>();
        int leftcount=0,startcount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                leftcount++;
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)=='*') {
                startcount++;
                stack.push(s.charAt(i));
            }
            else{
                if(leftcount==0){
                    if(startcount==0)
                        return false;
                    else{
                        stack.pop();
                        startcount--;
                    }
                }
                else{
                    char c;
                    while((c=stack.pop())!='(')
                        tempstack.push(c);
                    while(!tempstack.isEmpty())
                        stack.push(tempstack.pop());
                    leftcount--;
                }
            }
        }
        if(leftcount>startcount)
            return false;
        startcount=0;
        while (leftcount!=0){
            if((stack.peek())=='*') {
                tempstack.push(stack.pop());
                startcount++;
            }
            else{
                stack.pop();
                if(startcount==0)
                    return false;
                else {
                    leftcount--;
                    startcount--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Valid_Parenthesis_String test=new Valid_Parenthesis_String();
        System.out.println(test.checkValidString("()*()(()(*()(((())()()())*))()*()(*)(((*))(())(())((*()*(()(())()*(((*(**))((())*)(((()()))(())()))"));
    }
}
