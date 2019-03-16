package com.km;

import java.util.*;

public class test3 {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) {
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            map = new TreeMap<>();
            int ans = 0;
            int number = sc.nextInt();
            int[] grades = new int[number];
            int[] get = new int[number];
            input(number, grades);
            if (number == 2) {
                if (grades[0] != grades[1])
                    System.out.println(3);
                else
                    System.out.println(2);
                continue;
            } else if (number == 1) {
                System.out.println(1);
                continue;
            }
            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                int key = it.next();
                ArrayList<Integer> indexs = map.get(key);
                for (int index : indexs) {
                    int before, after;
                    before = index == 0 ? number - 1 : index - 1;
                    after = index == number - 1 ? 0 : index + 1;

                    if (grades[before] > key && grades[after] > key) {
                        get[index] = 1;
                        ans++;
                    } else if(grades[before] < key && grades[after] < key){
                        get[index] = get[before] > get[after] ? get[before] + 1 : get[after] + 1;
                        ans += get[index];
                    } else if((grades[before] == key && grades[after] < key)||(grades[before] < key && grades[after] == key)){
                        get[index] = grades[before] > grades[after] ? get[after] + 1 : get[before] + 1;
                        ans += get[index];
                    }
                    else{
                        get[index] = 1;
                        ans += get[index];
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static void input(int number, int[] grades) {
        for (int i = 0; i < number; i++) {
            grades[i] = sc.nextInt();
            ArrayList<Integer> list;
            if (map.containsKey(grades[i])) {
                list = map.get(grades[i]);
            } else
                list = new ArrayList<>();
            list.add(i);
            map.put(grades[i], list);
        }
    }
}
