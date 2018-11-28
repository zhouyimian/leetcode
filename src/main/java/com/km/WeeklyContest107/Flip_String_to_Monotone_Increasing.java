package com.km.WeeklyContest107;

public class Flip_String_to_Monotone_Increasing {
	public int minFlipsMonoIncr(String S) {
		if(S==null||S.equals("")||S.length()<=1)
			return 0;
		int[] left_1=new int[S.length()];
		int[] right_0=new int[S.length()];
		for(int i=1;i<S.length();i++) {
			left_1[i]=S.charAt(i-1)=='1'?left_1[i-1]+1:left_1[i-1];
		}
		for(int i=S.length()-2;i>=0;i--) {
			right_0[i]=S.charAt(i+1)=='0'?right_0[i+1]+1:right_0[i+1];
		}
		int ans=S.length();
		for(int i=0;i<S.length();i++)
			ans=Math.min(ans, left_1[i]+right_0[i]);
		return ans;
	}

	public static void main(String[] args) {
		Flip_String_to_Monotone_Increasing f=new Flip_String_to_Monotone_Increasing();
		System.out.println(f.minFlipsMonoIncr("00011000"));

	}

}
