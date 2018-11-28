package com.km.leetcode;

public class Guess_Number_Higher_or_Lower {
	public int guessNumber(int n) {
		int start=0;
		int end=n;
		while(start<=end) {
			int mid=start+(end-start)/2;
			int ans=guess(mid);
			if(ans==0)
				return mid;
			else if(ans==1) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		return -1;
	}
	int guess(int num) {
		return 0;
	}
}
