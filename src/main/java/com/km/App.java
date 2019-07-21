package com.km;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        long ans = 0;
        for(long i = 0;i<=100000000L;i++)
            ans+=i;
        System.out.println(ans);
    }
}
