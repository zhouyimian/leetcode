package com.km.WeeklyContest171;

public class Minimum_Flips_to_Make_a_OR_b_Equal_to_c {
    public int minFlips(int a, int b, int c) {
        StringBuilder coverA = new StringBuilder(Integer.toBinaryString(a));
        StringBuilder coverB = new StringBuilder(Integer.toBinaryString(b));
        StringBuilder coverC = new StringBuilder(Integer.toBinaryString(c));
        int ans = 0;
        deal(coverA);
        deal(coverB);
        deal(coverC);
        for(int i = 31;i>=0;i--){
            if(coverA.charAt(i)==coverB.charAt(i)){
                if(coverA.charAt(i)!=coverC.charAt(i)) {
                    if(coverA.charAt(i)=='0'){
                        ans++;
                    }else{
                        ans+=2;
                    }
                }
            }else{
                if(coverC.charAt(i)!='1'){
                    ans++;
                }
            }
        }
        return ans;

    }

    private void deal(StringBuilder sb) {
        while (sb.length()!=32){
            sb.insert(0,'0');
        }
    }

    public static void main(String[] args) {
        Minimum_Flips_to_Make_a_OR_b_Equal_to_c test = new Minimum_Flips_to_Make_a_OR_b_Equal_to_c();
        System.out.println(test.minFlips(1,2,3));
    }
}
