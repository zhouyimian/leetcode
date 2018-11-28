package com.km.WeeklyContest106;

public class Sort_Array_By_Parity_II {
	public int[] sortArrayByParityII(int[] A) {
		for(int i=0;i<A.length;i++) {
			if(i%2==0) {
				if(A[i]%2==0) continue;
				int j=i+1;
				while(j<A.length&&A[j]%2==1) j++;
				exchange(A,i,j);
			}
			else {
				if(A[i]%2==1) continue;
				int j=i+1;
				while(j<A.length&&A[j]%2==0) j++;
				exchange(A,i,j);
			}
		}
		return A;
	}

	public void exchange(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
}
