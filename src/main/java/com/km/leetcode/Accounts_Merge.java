package com.km.leetcode;

import java.util.*;

public class Accounts_Merge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,String> account_username = new HashMap<>();
        for(int i = 0;i<accounts.size();i++){
            boolean flag = false;
            String username = "";
            for(int j = 1;j<accounts.get(i).size();j++){
                if(account_username.containsKey(accounts.get(i).get(j))){
                    flag = true;
                    username = account_username.get(accounts.get(i).get(j));
                    break;
                }
            }
            if(flag){
                for(int j = 1;j<accounts.get(i).size();j++){
                    account_username.put(accounts.get(i).get(j),username);
                }
            }else{
                String addname = accounts.get(i).get(0)+"_"+i;
                for(int j = 1;j<accounts.get(i).size();j++){
                    account_username.put(accounts.get(i).get(j),addname);
                }
            }
        }
        Map<String,ArrayList<String>> tempans = new HashMap<>();
        for(Map.Entry<String,String> entry:account_username.entrySet()){
            String username = entry.getValue();
            String email = entry.getKey();
            ArrayList<String> temp = tempans.get(username);
            if(temp==null){
                temp = new ArrayList<>();
            }
            temp.add(email);
            tempans.put(username,temp);
        }
        Iterator<String> it = tempans.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            ArrayList<String> emaillist = tempans.get(key);
            ArrayList<String> anslist = new ArrayList<>();
            String name = deal(key);
            anslist.add(name);
            for(int j = 0 ;j<emaillist.size();j++)
                anslist.add(emaillist.get(j));
            ans.add(anslist);
        }
        return ans;
    }
    public String deal(String key){
        String[] splits = key.split("_");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<splits.length-1;i++)
            sb.append(splits[i]);
        return sb.toString();
    }
}
