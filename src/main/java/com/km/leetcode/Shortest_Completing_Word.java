package com.km.leetcode;

public class Shortest_Completing_Word {
	public static String shortestCompletingWord(String licensePlate, String[] words) {
		String ans = null;
		int minlength=1010;
		int[] time=new int[26];
		licensePlate=licensePlate.toLowerCase();
		for(int i=0;i<licensePlate.length();i++) {
			if((licensePlate.charAt(i)>='0'&&licensePlate.charAt(i)<='9')||licensePlate.charAt(i)==' ')
				continue;
			time[licensePlate.charAt(i)-'a']++;
		}
		for(int i=0;i<words.length;i++) {
			int[] temp=new int[26];
			words[i]=words[i].toLowerCase();
			for(int j=0;j<words[i].length();j++) {
				temp[words[i].charAt(j)-'a']++;
			}
			int flag=0;
			for(int k=0;k<26;k++) {
				if(time[k]>temp[k]) {
					flag=1;
					break;
				}
			}
			if(flag==1) {
				flag=0;
			}
			else {
				if (words[i].length() < minlength) {
					minlength = words[i].length();
					ans = words[i];
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String s1="1s3 PSt";
		String[] s= {"step","steps","stripe","stepple"};
		System.out.println(shortestCompletingWord(s1,s));
	}
}
