package com.km.Interiew;

import java.util.*;

public class binary_Search {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0||nums[0]>target)
            return 0;
        if(nums[nums.length-1]<target)
            return nums.length;
        int low = 0;
        int high = nums.length-1;
        int mid = low + (high-low)/2;
        while(low<high){
            mid = low + (high-low)/2;
            int before = mid-1;
            if(nums[mid]==target||(nums[mid]>target&&nums[before]<target))
                return mid;
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return mid>low?mid:low;
    }
    int[] parent;
    Map<Integer,ArrayList<Integer>> friends = new HashMap<>();
    public int findCircleNum(int[][] M) {
        parent = new int[M.length];
        for(int i = 0;i<parent.length;i++)
            parent[i] = i;
        for(int i = 0;i<M.length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0;j<M[i].length;j++){
                if(M[i][j]==1&&i!=j){
                    list.add(j);
                }
            }
            friends.put(i,list);
        }
        for(int i = 0;i<M.length;i++){
            ArrayList<Integer> list = friends.get(i);
            for(int j = 0;j<list.size();j++){
                int parentA = findparent(i);
                int parentB = findparent(list.get(j));
                parent[parentA] = parentB;
            }
        }
        Set<Integer> ans = new HashSet<>();
        for(int num:parent){
            ans.add(findparent(num));
        }

        return ans.size();
    }
    public int findparent(int num){
        if(num!=parent[num]){
            parent[num] = findparent(parent[num]);
        }
        return parent[num];
    }


}