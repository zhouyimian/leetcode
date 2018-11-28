package com.km.leetcode;

public class Two_Sum_II_Input_array_is_sorted {

	public static void main(String[] args) {
		int[] numbers= {2,3,4};
		int target=6;
		int index1,index2;
		for(int i=0;i<numbers.length;i++) {
			for(int j=numbers.length-1;j>i;j--) {
				if(numbers[i]+numbers[j]<target) {
					break;
				}
				if(numbers[i]+numbers[j]==target) {
					index1=i;
					index2=j;
					System.out.println(index1+1);
					System.out.println(index2+1);
				}
			}
		}
	}

}
