package com.km.leetcode;

import java.util.Arrays;

public class china_String {
	public static boolean buddyStrings(String A, String B) {
		char[] a=A.toCharArray();
		char[] b=B.toCharArray();
		StringBuilder sb=new StringBuilder();
		if(A.length()!=B.length())
			return false;
		int count=0;
		int pos1=-1;
		int pos2=-1;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=b[i]) {
				count++;
				if(count>2)
					return false;
				if(pos1==-1)
					pos1=i;
				else
					pos2=i;
			}
		}
		if(count==0) {
			for(int i=0;i<a.length;i++) {
				for(int j=i+1;j<a.length;j++) {
					if(a[i]==a[j])
						return true;
				}
			}
		}
		if(count!=2)
			return false;
		char temp=a[pos1];a[pos1]=a[pos2];a[pos2]=temp;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(buddyStrings("aa","aa"));
	}
	
}
