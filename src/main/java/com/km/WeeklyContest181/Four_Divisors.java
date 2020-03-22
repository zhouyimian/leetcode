package com.km.WeeklyContest181;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Four_Divisors {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int num:nums){
            int count = check(num);
            ans+=(count==-1?0:count);
        }
        return ans;
    }

    private int check(int num) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(num);
        for(int i = 2;i<=num/2;i++){
            if(num%i==0){
                set.add(i);
                set.add(num/i);
                if(set.size()>4)
                    return -1;
            }
        }
        if(set.size()!=4)
            return -1;
        int result = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext())
            result+=it.next();
        return result;
    }
}
