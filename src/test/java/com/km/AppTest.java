package com.km;

import java.util.*;


public class AppTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] strs= new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.next();
            }
            long ans = cal(strs);
            System.out.println(ans);
        }
    }
    public static long cal(String[] strs){
        Map<Character,Long> map = new HashMap<>();
        Set<Character> headzero = new HashSet<>();
        long ans = 0;
        for(String s : strs){
            setWeight(map,s,headzero);
        }
        List<Map.Entry<Character,Long>> list = new ArrayList<Map.Entry<Character,Long>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Long>>() {
            @Override
            public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {
                return o1.getValue()>o2.getValue()?-1:1;
            }
        });
        int number = 9;
        if(list.size()==10){
            for(int i = 9;i>=0;i--){
                if(!headzero.contains(list.get(i).getKey())){
                    list.remove(i);
                    break;
                }
            }
        }
        for(Map.Entry<Character,Long> entry:list){
            ans+= entry.getValue()*number;
            number--;
        }
        return ans;
    }
    public  static void setWeight(Map<Character,Long> map ,String s ,Set<Character> headzero){
        long weight = 1;
        for(int i = s.length()-1;i>=0;i--){
            if(map.get(s.charAt(i))==null){
                map.put(s.charAt(i),weight);
            }
            else{
                map.put(s.charAt(i),map.get(s.charAt(i))+weight);
            }
            weight*=10;
        }
        headzero.add(s.charAt(0));
    }
}
