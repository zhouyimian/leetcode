package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lexicographical_Numbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<10;i++){
            dfs(ans,i,n);
        }
        return ans;
    }

    private void dfs(List<Integer> ans, int cur, int n) {
        if(cur>n)
            return;
        ans.add(cur);
        for(int i=0;i<10;i++){
            if(10*cur+i>n)
                return;
            dfs(ans,10*cur+i,n);
        }
    }

    public static void main(String[] args) {
        Lexicographical_Numbers test =new Lexicographical_Numbers();
        List<Integer> list=test.lexicalOrder(13);
        for(Integer num:list)
            System.out.println(num);
    }
}
