package com.km.WeeklyContest102;

public class Sort_Array_By_Parity {
	public int[] sortArrayByParity(int[] A) {
		int[] jishu=new int[A.length];
		int[] oushu=new int[A.length];
		int jishucount=0;
		int oushucount=0;
		for(int i=0;i<A.length;i++) {
			if(A[i]%2==0) {
				oushu[oushucount++]=A[i];
			}
			else {
				jishu[jishucount++]=A[i];
			}
		}
		for(int j=oushucount;j<A.length;j++) {
			oushu[j]=jishu[j-oushucount];
		}
		return oushu;
	}
}
