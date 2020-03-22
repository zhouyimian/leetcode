package com.km.WeeklyContest181;

public class Longest_Happy_Prefix {
    public String longestPrefix(String s) {
        int mod = 1000000007;
        int a = 26;
        int n = s.length();
        long sHash = 0;
        long rHash = 0;
        long p = 1;
        int res = 0;
        for(int i=0; i<n-1; i++){
            int c = s.charAt(i)-'a';
            int rc = s.charAt(n-1-i)-'a';
            sHash = (sHash*a%mod + c)%mod;
            rHash = (rHash + rc*p%mod)%mod;
            p = p*a%mod;
            if(sHash==rHash){
                res=i+1;
            }
        }
        return s.substring(0, res);
    }

    public static void main(String[] args) {
        Longest_Happy_Prefix test = new Longest_Happy_Prefix();
        System.out.println(test.longestPrefix("a"));
        String s = "abcasd";
        System.out.println(s.hashCode());
    }
}
