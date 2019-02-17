package com.km.WeeklyContest124;

import java.util.*;

public class Number_of_Squareful_Arrays {

    //超时代码
    /*int[] vis;
    int ans = 0;
    List<ArrayList<Integer>> list = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public int numSquarefulPerms(int[] A) {
        vis = new int[A.length];
        for(int i = 0;i<A.length;i++){
            vis[i]=1;
            temp.add(A[i]);
            dfs(1,A[i],A);
            temp.remove(temp.size()-1);
            vis[i]=0;
        }
        return ans;
    }
    public void dfs(int count,int num,int[] A){
        if(count==A.length){
            boolean flag;
            for(int i =0;i<list.size();i++){
                flag=true;
                for(int j = 0;j<A.length;j++){
                    if(temp.get(j)!=list.get(i).get(j)){
                        flag=false;
                        break;
                    }
                }
                if(flag) return;
            }
            ans++;
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i<A.length;i++){
            if(vis[i]==0){
                if((int)(Math.sqrt(num+A[i]))*(int)(Math.sqrt(num+A[i]))==num+A[i]){
                    vis[i]=1;
                    temp.add(A[i]);
                    dfs(count+1,A[i],A);
                    temp.remove(temp.size()-1);
                    vis[i]=0;
                }
            }
        }
    }*/
    Map<Integer, Integer> cntMap = new HashMap<>();
    Map<Integer, Set<Integer>> squareMap = new HashMap<>();
    int cnt = 0;
    public int numSquarefulPerms(int[] A) {
        for (int num : A) {
            if (!cntMap.containsKey(num)) {
                cntMap.put(num, 1);
                squareMap.put(num, new HashSet<>());
            } else {
                cntMap.put(num, cntMap.get(num) + 1);
            }
        }
        for (int num1 : cntMap.keySet()) {
            for (int num2 : cntMap.keySet()) {
                double c = Math.sqrt(num1 + num2);
                if (c == Math.floor(c)) {
                    squareMap.get(num1).add(num2);
                    squareMap.get(num2).add(num1);
                }
            }
        }
        for (int num: cntMap.keySet()) {
            countPerm(num, A.length - 1);
        }
        return cnt;
    }

    private void countPerm(int num, int left) {
        cntMap.put(num, cntMap.get(num) - 1);
        if (left == 0) { cnt++; }
        else {
            for (int next : squareMap.get(num)) {
                if (cntMap.get(next) != 0) {
                    countPerm(next, left - 1);
                }
            }
        }
        cntMap.put(num, cntMap.get(num) + 1);
    }
}
