package com.km.leetcode;

public class Next_Greater_Element_I {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] ans = new int[nums1.length];
		int flag=0;
		for (int i = 0; i < nums1.length; i++) {
			int index = Search(nums2, nums1[i]);
			for(int j=index;j<nums2.length;j++) {
				if(nums2[j]>nums1[i]) {
					ans[i]=nums2[j];
					flag=1;
					break;
				}
			}
			if(flag==1) {
				flag=0;
				continue;
			}
			else {
				ans[i]=-1;
			}
		}
		return ans;
	}
	static int Search(int[] nums2,int num) {
		for(int i=0;i<nums2.length;i++) {
			if(nums2[i]==num)
				return i;
		}
		return 0;
	}
	public static void main(String[] args) {
		int[] nums1= {4,1,2};
		int[] nums2= {1,3,4,2};
		nextGreaterElement(nums1,nums2);
	}
}
