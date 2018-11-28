package com.km.WeeklyContest111;

public class Valid_Mountain_Array {
	public boolean validMountainArray(int[] A) {
		if(A.length<3)
			return false;
		int index=0;
		if(A[index]>A[index+1])
			return false;
		while(index<A.length-1&&A[index]<A[index+1]) 
			index++;
		if(index==A.length-1)
			return false;
		while(index<A.length-1&&A[index]>A[index+1]) 
			index++;
		return index==A.length-1?true:false;
	}
	public static void main(String[] args) {
		Valid_Mountain_Array test=new Valid_Mountain_Array();
		int[] nums= {9,8,7,6,5,4,3,2,1,0};
		System.out.println(test.validMountainArray(nums));
	}
}
