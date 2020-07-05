package com.km.WeeklyContest194;

public class XOR_Operation_in_an_Array {
    public int xorOperation(int n, int start) {
        int ans = start;
        for(int i = 1;i<n;i++){
            ans^=(start+i*2);
        }
        return ans;
    }
}
