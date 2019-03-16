package com.km;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] lengths = new int[n];
        int maxlength = -1;
        for(int i = 0;i<n;i++) {
            lengths[i] = sc.nextInt();
            maxlength = Math.max(maxlength,lengths[i]);
        }
        int calcount = 0;
        double low = 1;
        double high = 1000000000;
        double ans = 1;
        while(low<high){
            calcount++;
            if(calcount>=1000)
                break;
            double mid = low+(high-low)/2;
            int count = solve(mid,lengths);
            if(count<m)
                high = mid;
            else {
                ans = mid;
                low = mid;
            }
        }
        String s = ans+"";
        if(s.contains(".")){
            String[] strs = s.split("\\.");
            if(strs[1].length()>2){
                s = strs[0]+strs[1].substring(0,2);
            }else if(strs[1].length()<2){
                s = s+"0";
            }
        }else{
            s+=".00";
        }
        System.out.println(s);
    }
    public static int solve(double len,int[] lengths){
        int count = 0;
        for(int i = 0;i<lengths.length;i++)
            count+=(lengths[i]/len);
        return count;
    }
}
