package com.km.WeeklyContest197;

import java.util.HashMap;
import java.util.Map;

public class Number_of_Substrings_With_Only_1s {
    Map<Integer,Integer> cache = new HashMap<>();
    int MOD = 1000000007;
    public int numSub(String s) {
        long ans = 0;

        int start = 0;
        while (start<s.length()){
            int end = start;
            if(s.charAt(start)=='1') {
                while (end < s.length() && s.charAt(end) == '1'){
                    end++;
                }
                ans+=cal(end-start);
                ans%=MOD;
                start = end+1;
            }else{
                start++;
                continue;
            }
        }
        return (int) ans;
    }

    private long cal(int num) {
        if(cache.containsKey(num))
            return cache.get(num);
        long count = 1;
        cache.put(1,1);
        for(int i = 2;i<=num;i++){
            count+=i;
            cache.put(i,(int)(count%MOD));
        }
        return cache.get(num);
    }

    public static void main(String[] args) {
        Number_of_Substrings_With_Only_1s test = new Number_of_Substrings_With_Only_1s();
        System.out.println(test.numSub("111111"));
    }
}
