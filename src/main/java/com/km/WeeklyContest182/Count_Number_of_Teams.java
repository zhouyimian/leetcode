package com.km.WeeklyContest182;

public class Count_Number_of_Teams {
    public int numTeams(int[] rating) {
        int ans = 0;
        int length = rating.length;
        for(int i = 0;i<length;i++){
            for(int j = i+1;j<length;j++){
                if(rating[i]>rating[j]) continue;
                for(int k = j+1;k<length;k++){
                    if(rating[k]>rating[j])
                        ans++;
                }
            }
        }
        for(int i = 0;i<length;i++){
            for(int j = i+1;j<length;j++){
                if(rating[i]<rating[j]) continue;
                for(int k = j+1;k<length;k++){
                    if(rating[k]<rating[j])
                        ans++;
                }
            }
        }
        return ans;
    }
}
