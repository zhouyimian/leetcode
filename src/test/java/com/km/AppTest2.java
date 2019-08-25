package com.km;

import java.util.*;

public class AppTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        int ans = 1;
        while (sb.length()!=0){
            sb.deleteCharAt(0);
            if(sb.length()==1)
                break;
            int count = 0;
            for(int i = 0;i<sb.length();i++){
                if(sb.charAt(i)==')'){
                    sb.deleteCharAt(i);
                    if(check(sb))
                        count++;
                    sb.insert(i,')');
                }
            }
            ans*=count;
            for(int i = 0;i<sb.length();i++){
                if(sb.charAt(i)==')'){
                    sb.deleteCharAt(i);
                    if(check(sb))
                        break;
                    sb.insert(i,')');
                }
            }
        }
        System.out.println(ans==0?1:ans);
    }

    private static boolean check(StringBuilder sb) {
        int count = 0;
        for(int i = 0;i<sb.length();i++){
            if(sb.charAt(i)=='(')
                count++;
            else
                count--;
            if(count<0)
                return false;
        }
        return true;
    }
}
