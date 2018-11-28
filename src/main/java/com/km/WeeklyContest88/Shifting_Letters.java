package com.km.WeeklyContest88;

public class Shifting_Letters {
	public static String shiftingLetters(String S, int[] shifts) {
		StringBuilder sb=new StringBuilder(S);
		for(int i=shifts.length-2;i>=0;i--) {
			shifts[i]=shifts[i]%26+shifts[i+1]%26;
		}
		for(int i=0;i<shifts.length;i++) {
			int num=shifts[i]%26;
			char c=S.charAt(i);
			if(c+num>'z') {
				String t=new String(Character.toChars(c+num-26));
				sb.replace(i, i+1, t);
			}
			else {
				sb.replace(i, i+1, new String(Character.toChars(c+num)));
			}
			
		}
		return new String(sb);
	}
	public static void main(String[] args) {
		String s="z";
		int[] n= {52};
		System.out.println(shiftingLetters(s,n));
	}
}
