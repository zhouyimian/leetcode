package com.km.WeeklyContest87;

public class Backspace_String_Compare {
	public static boolean backspaceCompare(String S, String T) {
		StringBuilder sb1=new StringBuilder();
		StringBuilder sb2=new StringBuilder();
		for(int i=0;i<S.length();i++) {
			if(S.charAt(i)=='#') {
				if(sb1.length()>0)
					sb1.deleteCharAt(sb1.length()-1);
			}
			else
				sb1.append(S.charAt(i));
		}
		for(int i=0;i<T.length();i++) {
			if(T.charAt(i)=='#') {
				if(sb2.length()>0)
					sb2.deleteCharAt(sb2.length()-1);
			}
			else
				sb2.append(T.charAt(i));
		}
		S=new String(sb1);
		T=new String(sb2);
		return S.equals(T);
	}
	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c","ad#c"));
	}
}
