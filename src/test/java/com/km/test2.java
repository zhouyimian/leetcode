package com.km;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i = 0;i<count;i++){
            String s = sc.next();
            StringBuilder sb = new StringBuilder(s);
            solve(sb);
        }
    }
    public static void solve(StringBuilder sb){
        if(sb.length()<=2)
            System.out.println(sb);
        else{
            for(int i = 0;i<sb.length()-2;i++){
                while(i<sb.length()-2&&sb.charAt(i)==sb.charAt(i+1)&&sb.charAt(i+1)==sb.charAt(i+2)){
                    sb = sb.deleteCharAt(i);
                }
                while(i<sb.length()-3&&sb.charAt(i)==sb.charAt(i+1)&&sb.charAt(i+2)==sb.charAt(i+3)){
                    sb.deleteCharAt(i+2);
                }
            }

            System.out.println(sb);
        }
    }
}
