package com.km.WeeklyContest107;

public class Three_Equal_Parts {
	public int[] threeEqualParts(int[] A) {
        if (A == null || A.length < 3) return new int[] {-1, -1};
        int n = A.length;
        int cntOneBit = 0;
        
        for (int b : A) {
            if (b == 1) cntOneBit++;
        }
        if (cntOneBit % 3 != 0) return new int[] {-1, -1};
        
        int cnt = cntOneBit / 3;
        if (cnt == 0) return new int[] {0, n - 1};
    
        //construct the string using the right most part;
        int j = n - 1, cntR = 0;
        StringBuilder suffix = new StringBuilder();
        for (;j >= 0 && cntR < cnt; j--) {
            suffix.append(A[j]);
            if (A[j] == 1) cntR++;
         } 
    
        String target = suffix.reverse().toString();
        
        //matching the left part with target string, omit all leading zero
        int i = 0;
        while (A[i] == 0) i++;
    
        int k = 0;
        while (k < target.length()) {
            if (A[i + k] == target.charAt(k) - '0') k++;
            else return new int[] {-1, -1};
        }
        int left = i + k -1;
        
        //matching the middle part with target string, omit all leading zero
        i = i + k;
        while (A[i] == 0) i++;
        k = 0;
        while (k < target.length()) {
        if (A[i + k] == target.charAt(k) - '0') k++;
            else return new int[] {-1, -1};
        }    
        return new int[] {left, i + k}; 
    }

	public static void main(String[] args) {
		Three_Equal_Parts s = new Three_Equal_Parts();
		int[] A = { 0, 0, 0, 0, 0 };
		int[] ans = s.threeEqualParts(A);
		System.out.println(ans[0] + "   " + ans[1]);
	}

}
