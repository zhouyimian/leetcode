package com.km.WeeklyContest201;

public class Find_Kth_Bit_in_Nth_Binary_String {
    public char findKthBit(int n, int k) {
        StringBuilder[] strs = new StringBuilder[22];
        strs[1] = new StringBuilder("0");
        for(int i = 2;i<=n;i++){
            strs[i] = new StringBuilder(strs[i-1]).append('1').append(deal(strs[i-1]));
        }
        return strs[n].charAt(k-1);
    }

    private StringBuilder deal(StringBuilder str) {
        StringBuilder res = new StringBuilder();
        for(char c:str.toString().toCharArray()){
            res.append(c=='0'?'1':'0');
        }
        return res.reverse();
    }

    public static void main(String[] args) {
        Find_Kth_Bit_in_Nth_Binary_String test = new Find_Kth_Bit_in_Nth_Binary_String();
        System.out.println(test.findKthBit(3,1));
    }
}
