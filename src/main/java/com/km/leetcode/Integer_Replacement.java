package com.km.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Integer_Replacement {
    public int integerReplacement(int n) {
        List<Long> queue = new ArrayList<>();
        if(n==1)
            return 0;
        int ans = 0;
        queue.add((long)n);
        Set<Long> set = new HashSet<>();
        while(queue.size()!=0){
            List<Long> temp = new ArrayList<>();
            int length = queue.size();
            for(int i = 0;i<length;i++){
                long num = queue.get(i);
                if(num==1)
                    return ans;
                if((num&1)==0){
                    if(!set.contains(num/2)){
                        temp.add(num/2);
                        set.add(num/2);
                    }
                }else{
                    if(!set.contains(num-1)){
                        temp.add(num-1);
                        set.add(num-1);
                    }
                    if(!set.contains(num+1)){
                        temp.add(num+1);
                        set.add(num+1);
                    }
                }
            }
            ans++;
            queue.clear();
            queue.addAll(temp);
            temp.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer_Replacement test = new Integer_Replacement();
        System.out.println(test.integerReplacement(2147483647));
    }
}
