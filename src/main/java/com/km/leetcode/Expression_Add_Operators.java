package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators {
    List<String> ans = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num==null||num.length()==0)
            return ans;
        dfs("",num,target,0,0,0);
        return ans;
    }
    public void dfs(String path, String num, int target, int pos, long eval, long multed){
        if(pos==num.length()){
            if(eval==target)
                ans.add(path);
            return;
        }
        for(int i = pos;i<num.length();i++){
            if(i!=pos&&num.charAt(pos)=='0')
                break;
            long cur = Long.parseLong(num.substring(pos,i+1));
            if(pos==0){
                dfs(path+cur,num,target,i+1,eval+cur,cur);
            }else{
                dfs(path+"+"+cur,num,target,i+1,eval+cur,cur);
                dfs(path+"-"+cur,num,target,i+1,eval-cur,-cur);
                dfs(path+"*"+cur,num,target,i+1,eval-multed+multed*cur,multed*cur);
            }
        }
    }

    public static void main(String[] args) {
        Expression_Add_Operators test = new Expression_Add_Operators();
        List<String> ans = test.addOperators("10",10);
        for(String s:ans)
            System.out.println(s);
    }
}
