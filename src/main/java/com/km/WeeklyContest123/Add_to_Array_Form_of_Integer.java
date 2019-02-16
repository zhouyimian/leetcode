package com.km.WeeklyContest123;

import java.util.ArrayList;
import java.util.List;

public class Add_to_Array_Form_of_Integer {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        String b = K+"";
        int[] leng = new int[A.length>b.length()?A.length:b.length()];
        int[] shor = new int[A.length>b.length()?A.length:b.length()];
        int diff = Math.abs(A.length-b.length());
        if(A.length!=leng.length){
            for(int i =0;i<leng.length;i++){
                if(i<diff)
                    shor[i] = 0;
                else
                    shor[i] = A[i-diff];
            }
            for(int i = 0;i<leng.length;i++)
                leng[i]=b.charAt(i)-'0';
        }
        else{
            for(int i =0;i<leng.length;i++)
                leng[i]=A[i];
            for(int i = 0;i<leng.length;i++){
                if(i<diff)
                    shor[i] = 0;
                else
                    shor[i] = b.charAt(i-diff)-'0';
            }
        }
        int[] ans = new int[leng.length];
        int jinwei = 0;
        for(int i = ans.length-1;i>=0;i--) {
            ans[i] = leng[i] + shor[i] + jinwei;
            jinwei=0;
            if(ans[i]>=10){
                ans[i]-=10;
                jinwei=1;
            }
        }
        if(jinwei!=0)
            result.add(jinwei);
        for(int i = 0;i<ans.length;i++)
            result.add(ans[i]);
        return result;
    }
}
