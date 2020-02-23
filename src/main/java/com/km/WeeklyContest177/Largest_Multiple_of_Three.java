package com.km.WeeklyContest177;

import java.util.*;

public class Largest_Multiple_of_Three {
    public String largestMultipleOfThree(int[] digits) {
        List<Integer> list = new ArrayList<>();
        List<Integer> num0 = new ArrayList<>();
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        int sum = 0;
        for(int num:digits) {
            int temp = num;
            int count = 0;
            while (temp != 0) {
                count += temp % 10;
                temp /= 10;
            }
            sum+=count;
            if (count % 3 == 1)
                num1.add(num);
            else if (count % 3 == 2)
                num2.add(num);
            else
                num0.add(num);
        }
        Collections.sort(num1);
        Collections.sort(num2);
        StringBuilder sb = new StringBuilder();
        if (sum % 3 == 1) {
            if(num1.size()!=0)
                num1.remove(0);
            else{
                num2.remove(0);
                num2.remove(0);
            }
        } else if (sum % 3 == 2) {
            if(num2.size()!=0) {
                num2.remove(0);
            }
            else{
                num1.remove(0);
                num1.remove(0);
            }
        }
        list.addAll(num0);
        list.addAll(num1);
        list.addAll(num2);
        Collections.sort(list, (o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s2.compareTo(s1);
        });
        for (int num : list)
            sb.append(num);
        if(sb.length()==0)
            return sb.toString();
        else
            while (sb.length()!=1&&sb.charAt(0)=='0')
                sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        Largest_Multiple_of_Three test = new Largest_Multiple_of_Three();
        int[] nums = {2,1,1,1};
        System.out.println(test.largestMultipleOfThree(nums));
    }
}
