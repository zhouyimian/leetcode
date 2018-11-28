package com.km.WeeklyContest77;

public class Number_of_Lines_To_Write_String {
	public int[] numberOfLines(int[] widths, String S) {
		int[] ans=new int[2];
		ans[0]=1;
		int length=0;
		int curr=0;
		int l=0;
		while(curr!=S.length()) {
			l=length+widths[S.charAt(curr)-'a'];
			if(l>100) {
				length=0;
				ans[0]++;
				continue;
			}
			else {
				length+=widths[S.charAt(curr)-'a'];
				curr++;
			}
		}
		ans[1]=l;
		return ans;
	}
}
