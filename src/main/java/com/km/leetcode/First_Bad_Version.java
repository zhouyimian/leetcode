package com.km.leetcode;

public class First_Bad_Version {
	public static int firstBadVersion(int n) {
		int num = n;
		int low = 0;
		int high = n;
		while (low <= high) {
			int mid = low+(high-low)/2;
			if (!isBadVersion(mid))
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}

	static boolean isBadVersion(int version) {
		if (version < 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(firstBadVersion(1));
	}
}
