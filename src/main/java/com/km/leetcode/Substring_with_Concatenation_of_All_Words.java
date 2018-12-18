package com.km.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0 || words[0].length() == 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int length = words.length;
        int wordlen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        for (int i = 0; i <= s.length() - length * wordlen; i++) {
            int k = i;
            Map<String, Integer> copy = new HashMap<>(map);
            while (k!=i+length*wordlen) {
                String word = s.substring(k, k + wordlen);
                if(copy.get(word)==null||copy.get(word)<1)
                    break;
                copy.put(s.substring(k,k+wordlen),copy.get(s.substring(k,k+wordlen))-1);
                k+=wordlen;
            }
            if(k==i+length*wordlen)
                res.add(i);
        }
        return res;
    }
}

