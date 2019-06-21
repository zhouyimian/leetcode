package com.km.WeeklyContest140;

import java.util.Stack;

public class Smallest_Subsequence_of_Distinct_Characters {
    public String smallestSubsequence(String text) {
        Stack<Character> stack = new Stack<>();
        int[] last = new int[26];
        for(int i = 0;i<text.length();i++){
            last[text.charAt(i)-'a'] = i;
        }
        boolean[] vis = new boolean[26];
        for(int i = 0;i<text.length();i++){
            char c = text.charAt(i);
            if(vis[c-'a']) continue;
            while(!stack.isEmpty()&&c<stack.peek()&&last[stack.peek()-'a']>i)
                vis[stack.pop()-'a'] = false;
            stack.push(c);
            vis[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb = sb.reverse();
        return sb.toString();
    }
}
