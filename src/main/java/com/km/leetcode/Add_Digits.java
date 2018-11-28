package com.km.leetcode;

public class Add_Digits {
	public int addDigits(int num) {
		while(num<=10) {
			int temp=num;
			int num2=0;
			while(temp!=0) {
				num2+=temp%10;
				temp=temp/10;
			}
			temp=num2;
			num=num2;
		}
		return num;
	}
}
