package com.km.WeeklyContest67;

public class Prime_Number_of_Set_Bits_in_Binary_Representation {
	public int countPrimeSetBits(int L, int R) {
		int ans=0;
		for(int i=L;i<=R;i++) {
			if(check(Integer.toBinaryString(i)))
				ans++;
		}
		return ans;
	}
	boolean check(String s) {
		int count=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='1')
				count++;
		}
		if(count==1)
			return false;
		if(count==2||count==3)
			return true;
		for(int i=2;i<=count/2;i++)
			if(count%i==0)
				return false;
		return true;
	}
}
