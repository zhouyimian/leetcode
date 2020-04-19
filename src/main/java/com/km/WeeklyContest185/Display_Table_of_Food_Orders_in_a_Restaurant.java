package com.km.WeeklyContest185;

import java.util.*;

public class Display_Table_of_Food_Orders_in_a_Restaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> foods = new TreeSet<>();
        List<String> firstLine = new ArrayList<>();
        firstLine.add("Table");
        for (List<String> oneCustomer : orders) {
            foods.add(oneCustomer.get(2));
        }
        firstLine.addAll(foods);
        Map<Integer, Map<String, Integer>> tableUserCount = new TreeMap<>();
        for (int i = 0; i < orders.size(); i++) {
            Integer tableNumber = Integer.parseInt(orders.get(i).get(1));
            String foodName = orders.get(i).get(2);
            Map<String, Integer> map = tableUserCount.getOrDefault(tableNumber, new TreeMap<>());
            if (map.size() == 0) {
                for (int j = 1; j < firstLine.size(); j++) {
                    map.put(firstLine.get(j), 0);
                }
            }
            map.put(foodName, map.get(foodName) + 1);
            tableUserCount.put(tableNumber,map);
        }
        ans.add(firstLine);
        tableUserCount.forEach((key, value) -> {
            List<String> oneLine = new ArrayList<>();
            oneLine.add(key+"");
            value.forEach((foodName,count)->{
                oneLine.add(count+"");
            });
            ans.add(oneLine);
        });
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        List<String> one = new ArrayList<>();
        one.add("David");
        one.add("3");
        one.add("food");
        orders.add(one);
        Display_Table_of_Food_Orders_in_a_Restaurant test = new Display_Table_of_Food_Orders_in_a_Restaurant();
        System.out.println(test.displayTable(orders));
    }
}
