package com.km.WeeklyContest167;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sequential_Digits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<StringBuilder> queue = new ArrayList<>();
        List<StringBuilder> maybeAns = new ArrayList<>();
        for(int i = 1;i<=9;i++)
            queue.add(new StringBuilder(i+""));
        while (true){
            List<StringBuilder> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                StringBuilder sb = new StringBuilder(queue.get(i));
                char c = sb.charAt(sb.length()-1);
                if(c!='9'){
                    sb.append((c-'0')+1);
                    temp.add(sb);
                }
            }
            if(temp.size()==0)
                break;
            maybeAns.addAll(temp);
            queue.clear();
            queue.addAll(temp);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<maybeAns.size();i++){
            int num = Integer.parseInt(maybeAns.get(i).toString());
            if(num>=low&&num<=high)
                ans.add(num);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        Sequential_Digits t = new Sequential_Digits();
        System.out.println(t.sequentialDigits(100,300));
    }
}
