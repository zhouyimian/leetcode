package com.km.WeeklyContest188;

import java.util.ArrayList;
import java.util.List;

public class Build_an_Array_With_Stack_Operations {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        int nowNum = 1;
        while (nowNum<=n&&index<target.length){
            if(nowNum==target[index]){
                ans.add("Push");
                index++;
            }else{
                ans.add("Push");
                ans.add("Pop");
            }
            nowNum++;
        }
        return ans;
    }
}
