package com.km.WeeklyContest198;

import java.util.*;

public class Maximum_Number_of_Non_Overlapping_Substrings {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> ans = new ArrayList<>();
        Map<Character,Integer> startIndex = new HashMap<>();
        Map<Character,Integer> endIndex = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(!startIndex.containsKey(c))
                startIndex.put(c,i);
            endIndex.put(c,i);
        }
        int[][] nums = new int[startIndex.size()][2];
        int index = 0;
        for(Map.Entry<Character,Integer> entry:startIndex.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            nums[index][0] = value;
            nums[index++][1] = endIndex.get(key);
        }
        boolean[] noUse = new boolean[startIndex.size()];
        Arrays.sort(nums, (o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        for(int i = 0;i<nums.length;i++){
            if(noUse[i])
                continue;
            for(int j = i+1;j<nums.length;j++){
                if(nums[j][1]<=nums[i][1]){
                    noUse[i] = true;
                    break;
                }
            }
        }
        int nowEnd = 0;
        boolean[] used = new boolean[startIndex.size()];
        for(int i = 0;i<nums.length;i++){
            int minIndex = -1;
            for(int j = 0;j<nums.length;j++){
                if(noUse[j]||used[j]||nums[j][0]<nowEnd)
                    continue;
                minIndex = minIndex==-1?j:(nums[j][1]<nums[minIndex][1]?j:minIndex);
            }
            if(minIndex==-1)
                break;
            nowEnd = nums[minIndex][1];
            used[minIndex] = true;
            ans.add(s.substring(nums[minIndex][0],nums[minIndex][1]+1));
        }
        return ans;
    }

    public static void main(String[] args) {
        Maximum_Number_of_Non_Overlapping_Substrings test = new Maximum_Number_of_Non_Overlapping_Substrings();
        System.out.println(test.maxNumOfSubstrings("abab"));
    }
}
