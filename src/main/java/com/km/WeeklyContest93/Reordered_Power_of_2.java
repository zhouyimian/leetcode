package com.km.WeeklyContest93;

public class Reordered_Power_of_2 {
	public static boolean reorderedPowerOf2(int N) {
		int[] num=new int[50];
		int count=0;
		for(int i=0;i<50;i++) {
			num[count++]=(int) Math.pow(2.0, i);
			if(num[count-1]>1000000000)
				break;
		}
		for(int i=0;i<count;i++) {
			String s1=Integer.toString(N);
			String s2=Integer.toString(num[i]);
			if(s1.length()>s2.length())
				continue;
			else if(s1.length()==s2.length()&&mycompare(s1,s2))
				return true;
			else if(s1.length()<s2.length())
				return false;
		}
		return false;
	}
	public static boolean mycompare(String s1, String s2) {
		int[] numbers1=new int[10];
		int[] numbers2=new int[10];
		for(int i=0;i<s1.length();i++) {
			numbers1[s1.charAt(i)-'0']++;
			numbers2[s2.charAt(i)-'0']++;
		}
		for(int i=0;i<10;i++)
			if(numbers1[i]!=numbers2[i])
				return false;
		return true;
	}
	public static void main(String[] args) {
		System.out.println(reorderedPowerOf2(46));
	}
}
