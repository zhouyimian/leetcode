package com.km;

import java.util.*;

public class Solution {
    public String minRemove (String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for(char c:s.toCharArray()){
            if(c=='('){
                flag = true;
                stack.push(c);
            }else if(c==')'){
                if(stack.isEmpty())
                    continue;
                else{
                    StringBuilder tempsb = new StringBuilder();
                    tempsb.append(c);
                    while (!stack.isEmpty()) {
                        char temp = stack.pop();
                        tempsb.append(temp);
                        if (temp == '(') {
                            break;
                        }
                    }
                    sb.append(tempsb.reverse());
                    if(stack.isEmpty())
                        flag = false;
                }
            }else{
                if(flag)
                    stack.push(c);
                else
                    sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minRemove("))(("));
    }
}
