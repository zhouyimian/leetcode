package com.km.WeeklyContest179;

import java.util.ArrayList;
import java.util.List;

public class Time_Needed_to_Inform_All_Employees {
    int ans = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1)
            return 0;
        List<List<Integer>> relation = new ArrayList<>();
        for(int i = 0;i<n;i++)
            relation.add(new ArrayList<>());
        for(int i = 0;i<manager.length;i++){
            if(i!=headID)
                relation.get(manager[i]).add(i);
        }
        DFS(headID,relation,informTime,0);
        return ans;
    }

    private void DFS(int headID, List<List<Integer>> relation, int[] informTime,int useTime) {
        List<Integer> employ = relation.get(headID);
        if(employ.size()==0){
            ans = Math.max(ans,useTime);
            return;
        }else{
            for(int i = 0;i<employ.size();i++){
                DFS(employ.get(i),relation,informTime,useTime+informTime[headID]);
            }
        }
    }

    public static void main(String[] args) {
        Time_Needed_to_Inform_All_Employees test = new Time_Needed_to_Inform_All_Employees();
        int[] manage = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] info = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        System.out.println(test.numOfMinutes(15,0,manage,info));
    }
}
