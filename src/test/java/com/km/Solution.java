package com.km;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] ans = new BigInteger[n + 1];
        if(n==1)
            System.out.println("1 1");
        else if(n==2)
            System.out.println("1 2 1");
        else{
            for(int i = 0;i<=n;i++)
                ans[i] = new BigInteger("0");
            ans[0] = new BigInteger("1");
            ans[1] = new BigInteger("2");
            ans[2] = new BigInteger("1");
            for(int i = 3;i<=n;i++){
                for(int j = n;j>0;j--){
                    ans[j] =  ans[j].add(ans[j-1]);
                }
            }
            for(int i = 0;i<=n;i++){
                if(i!=n)
                    System.out.print(ans[i]+" ");
                else
                    System.out.println(ans[i]);
            }
        }
    }
}
