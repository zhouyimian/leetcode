package com.Biweekly.BiweeklyContest19;

public class Number_of_Steps_to_Reduce_a_Number_to_Zero {
    public int numberOfSteps (int num) {
        int ans = 0;
        while (num!=0){
            if(num%2==0)
                num/=2;
            else
                num--;
            ans++;
        }
        return ans;
    }
}
