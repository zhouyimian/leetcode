package com.km.WeeklyContest143;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path_In_Zigzag_Labelled_Binary_Tree {
    public List<Integer> pathInZigZagTree(int label) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        int num = 1;
        int count = 1;
        for(int i = 1;i<=20;i++){
            List<Integer> cur = new ArrayList<>();
            for(int j = 1;j<=count;j++){
                cur.add(num++);
            }
            if(i%2==0) {
                Collections.reverse(cur);
            }
            cur.add(0,0);
            list.add(cur);
            count*=2;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        dfs(1,1,ans);
        return ans;
    }
    public void dfs(int ceng,int index,List<Integer> ans){

    }
//1048576
    public static void main(String[] args) {
        Path_In_Zigzag_Labelled_Binary_Tree test = new Path_In_Zigzag_Labelled_Binary_Tree();
        List<Integer> ans = test.pathInZigZagTree(14);
        for(int num:ans)
            System.out.println(num);
    }
}
