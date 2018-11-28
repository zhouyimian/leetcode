package com.km.WeeklyContest95;

public class Nth_Magical_Number {
	public static int nthMagicalNumber(int N, int A, int B) {
		long min=Math.min(A,B);
		long max=N*(A>B?A:B);
		long low=min,high=max,mid=(low+high)/2;
		long n=gcd(A,B);
		while(low<=mid) {
			if(mid%A==0||mid%B==0) {
				if((mid/A+mid/B-mid/n)==N) {
					return (int) mid;
				}
			}
			if((mid/A+mid/B-mid/n)>=N)
				high=mid;
			else
				low=mid+1;
			mid=(low+high)/2;
		}
		return 0;
	}

	public static long gcd(long A, long B) {
		return A * B / MaxCommon(A, B);
	}

	public static long MaxCommon(long num1, long num2) {
		if (num1 < num2) {
			long temp = num1;
			num1 = num2;
			num2 = temp;
		}

		if (num1 % num2 == 0) {
			return num2;
		} else {
			return MaxCommon(num2, num1 % num2);
		}
	}
	public static void main(String[] args) {
		System.out.println(nthMagicalNumber(1000000000,40000,40000));
	}
}
