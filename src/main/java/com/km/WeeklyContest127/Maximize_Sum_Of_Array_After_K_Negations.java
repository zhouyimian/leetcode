package com.km.WeeklyContest127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Maximize_Sum_Of_Array_After_K_Negations {
    public int largestSumAfterKNegations(int[] A, int K) {
        List<Integer> positivelist = new ArrayList<>();
        List<Integer> negativelist = new ArrayList<>();
        for(int num:A){
            if(num>=0)
                positivelist.add(num);
            else
                negativelist.add(num);
        }
        Collections.sort(negativelist);
        while(K>0&&negativelist.size()!=0){
            positivelist.add(-negativelist.get(0));
            negativelist.remove(0);
            K--;
        }
        Collections.sort(negativelist);
        Collections.sort(positivelist);
        int ans = 0;
        if(K==0||(negativelist.size()==0&&K%2==0)){
            for(int num:positivelist)
                ans+=num;
            for(int num:negativelist)
                ans+=num;
            return ans;
        }else{
            for(int num:positivelist)
                ans+=num;
            ans-=2*positivelist.get(0);
            return ans;
        }
    }
}
