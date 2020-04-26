package com.km.WeeklyContest186;

public class Maximum_Score_After_Splitting_a_String {
    public int maxScore(String s) {
        int ans = 0;
        int oneCount = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='1')
                oneCount++;
        }
        int curAns = s.charAt(0)=='1'?oneCount-1:oneCount;
        for(int i = 0;i<s.length()-1;i++){
            char c = s.charAt(i);
            if(c=='0') {
                curAns++;
            }
            else {
                if(i!=0)
                    curAns--;
            }
            ans = Math.max(ans,curAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        Maximum_Score_After_Splitting_a_String test = new Maximum_Score_After_Splitting_a_String();
        System.out.println(test.maxScore("11100"));
    }
}
