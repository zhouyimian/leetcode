package com.km.WeeklyContest128;

public class Complement_of_Base_10_Integer {
    public int bitwiseComplement(int N) {
        String res = Integer.toBinaryString(N);
        String ans="";
        for (int i=0; i<res.length(); i++)
            ans+=res.charAt(i)=='1'?'0':'1';
        return Integer.parseInt(ans, 2);
    }
}
