package com.km.WeeklyContest178;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Rank_Teams_by_Votes {
    public String rankTeams(String[] votes) {
        StringBuilder ans = new StringBuilder();
        if (votes.length == 1 || votes[0].length() == 1)
            return votes[0];
        Set<Character> person = new HashSet<>();
        Set<Character> hasvote = new HashSet<>();
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[i].length(); j++) {
                person.add(votes[i].charAt(j));
            }
        }
        List<Character> res = sort(person,0,votes);
        for(char c:res)
            ans.append(c);
        return ans.toString();
    }

    private List<Character> sort(Set<Character> haveToSort, int time, String[] votes) {
        List<Character> res = new ArrayList<>();
        if (haveToSort.size() == 0||time>=votes[0].length())
            return res;
        int[] count = new int[26];
        int maxCount = 0;
        for (int i = 0; i < votes.length; i++) {
            char c = votes[i].charAt(time);
            if (!haveToSort.contains(c))
                continue;
            count[c - 'A']++;
            if (count[c - 'A'] > maxCount)
                maxCount = count[c - 'A'];
        }
        Map<Integer,TreeSet<Character>> map = new TreeMap<>((o1, o2) -> o2-o1);
        for (int j = 0; j < 26; j++) {
            if(haveToSort.contains((char)(j+'A'))){
                TreeSet<Character> set = map.getOrDefault(count[j],new TreeSet<>());
                set.add((char)(j+'A'));
                map.put(count[j],set);
            }
        }
        for(Map.Entry<Integer,TreeSet<Character>> entry:map.entrySet()){
            Set<Character> values = entry.getValue();
            if(values.size()==1){
                char c = values.iterator().next();
                res.add(c);
                haveToSort.remove(c);
            }else{
                List<Character> nextRes = sort(values, time + 1, votes);
                for(char c:nextRes){
                    res.add(c);
                    haveToSort.remove(c);
                }
                if(values.size()!=0){
                    for(char c:values){
                        res.add(c);
                        haveToSort.remove(c);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Rank_Teams_by_Votes test = new Rank_Teams_by_Votes();
        String[] s = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        System.out.println(test.rankTeams(s));
    }
}


