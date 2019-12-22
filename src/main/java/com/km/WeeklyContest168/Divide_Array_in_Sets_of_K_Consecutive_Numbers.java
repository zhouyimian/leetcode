package com.km.WeeklyContest168;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Divide_Array_in_Sets_of_K_Consecutive_Numbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        while (map.size()!=0){
            for(int i = 0;i<nums.length;i++){
                if(map.containsKey(nums[i])){
                    for(int j = 0;j<k;j++){
                        if(!map.containsKey(nums[i]+j)){
                            return false;
                        }else{
                            if(map.get(nums[i]+j)==1){
                                map.remove(nums[i]+j);
                            }else{
                                map.put(nums[i]+j,map.get(nums[i]+j)-1);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
