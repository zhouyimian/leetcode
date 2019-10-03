package com.km.WeeklyContest156;

public class Get_Equal_Substrings_Within_Budget {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int start = 0;
        int diff = 0;
        int end= 0;
        while (start<=end&&end<s.length()){
            diff+=Math.abs(s.charAt(end)-t.charAt(end));
            if(diff<=maxCost) {
                ans = Math.max(ans,end-start+1);
                end++;
            }
            else{
                if(start==end){
                    start++;
                    end++;
                    diff=0;
                    continue;
                }
                diff-=Math.abs(s.charAt(start)-t.charAt(start));
                diff-=Math.abs(s.charAt(end)-t.charAt(end));
                start++;
            }
        }
        return ans;
    }
}
