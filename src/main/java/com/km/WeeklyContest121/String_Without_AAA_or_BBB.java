package com.km.WeeklyContest121;

public class String_Without_AAA_or_BBB {
    public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();
        if(A==B)
            return new String(aequlab(A));
        while(A!=0||B!=0){
            if(A==0){
                for(int i=0;i<B;i++)
                    ans.append('b');
                break;
            }
            else if(B==0){
                for(int i=0;i<A;i++)
                    ans.append('a');
                break;
            }
            else if(A>B){
                ans.append("aab");
                A-=2;
                B--;
            }
            else if(B>A){
                ans.append("bba");
                A--;
                B-=2;
            }
            else{
                ans.append(aequlab(A));
                break;
            }
        }
        return new String(ans);
    }
    public StringBuilder aequlab(int count){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++){
            sb.append("ab");
        }
        return sb;
    }
}
