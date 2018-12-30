package com.km.WeeklyContest117;

import java.util.*;

public class Vowel_Spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> first = new HashMap<>();
        HashMap<String, String> second = new HashMap<>();
        for(String str:wordlist){
            String lower=str.toLowerCase(),temp=lower.replaceAll("[aeiou]","#");
            first.putIfAbsent(lower,str);
            second.putIfAbsent(temp,str);
        }
        for(int i=0;i<queries.length;i++){
            if(words.contains(queries[i]))
                continue;
            String lower=queries[i].toLowerCase(),temp=lower.replaceAll("[aeiou]","#");
            if(first.containsKey(lower))
                queries[i]=first.get(lower);
            else if(second.containsKey(temp))
                queries[i]=second.get(temp);
            else
                queries[i]="";
        }
        return queries;
    }

    public static void main(String[] args) {
        String[] wordlists = {"KiTe", "kite", "hare", "Hare"};
        String[] querylists = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        Vowel_Spellchecker test = new Vowel_Spellchecker();
        for (String str : test.spellchecker(wordlists, querylists)) {
            System.out.println(str);
        }
    }
}
