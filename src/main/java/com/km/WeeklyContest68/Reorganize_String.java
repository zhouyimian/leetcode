package com.km.WeeklyContest68;

public class Reorganize_String {
	public static String reorganizeString(String S) {
		int[] nums=new int[26];
		for(int i=0;i<S.length();i++) {
			nums[S.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++) {
			if(S.length()%2==0&&nums[i]>S.length()/2)
				return "";
			else if(S.length()%2==1&&(nums[i]-1)>S.length()/2)
				return "";
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<26;i++) {
			int max=0;
			int max_index=0;
			for(int j=0;j<26;j++) {
				if(nums[j]>max) {
					max=nums[j];
					max_index=j;
				}
			}
			if(max==0)
				break;
			else {
				for(int j=0;j<max;j++)
					sb.append((char)(max_index+'a'));
				nums[max_index]=0;
			}
		}
		S=new String(sb);
		for(int i=0;i<S.length()-1;i++) {
			int j=S.length()-1;
			if(S.charAt(i)==S.charAt(i+1)) {
				while(j>i) {
					if(S.charAt(j)==S.charAt(i+1)||(j!=S.length()-1&&S.charAt(j+1)==S.charAt(i+1))) {
						j--;
					}
					else {
						S=exchange(S,i+1,j);
						break;
					}
				}
			}
		}
		return S;
	}
	static String exchange(String s,int i,int j) {
		StringBuilder sb=new StringBuilder(s);
		sb.setCharAt(i, s.charAt(j));
		sb.setCharAt(j, s.charAt(i));
		return new String(sb);
	}
	public static void main(String[] args) {
		String s="blflxll";
		System.out.println(reorganizeString(s));
	}
}
