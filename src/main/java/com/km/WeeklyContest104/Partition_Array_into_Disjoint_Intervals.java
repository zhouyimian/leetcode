package com.km.WeeklyContest104;

public class Partition_Array_into_Disjoint_Intervals {
	public int partitionDisjoint(int[] A) {
		int[] small=new int[A.length];
		int[] big=new int[A.length];
		for(int i=0;i<A.length;i++)
			big[i]=i==0?A[i]:Math.max(big[i-1], A[i]);
		for(int i=A.length-1;i>=0;i--)
			small[i]=i==A.length-1?A[i]:Math.min(small[i+1], A[i]);
		for(int i=0;i<A.length;i++)
			if(i==A.length-1)
				return i+1;
			else if(big[i]<=small[i+1])
				return i+1;
		return 0;
	}
	public static void main(String[] args) {
		int[] num= {1,1,1,0,6,12};
		Partition_Array_into_Disjoint_Intervals x=new Partition_Array_into_Disjoint_Intervals();
		System.out.println(x.partitionDisjoint(num));
	}
}
