package com.km.WeeklyContest84;

public class Find_And_Replace_in_String {
	public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		for(int i=0;i<indexes.length;i++) {
			for(int j=i+1;j<indexes.length;j++) {
				if(indexes[i]>indexes[j]) {
					int temp=indexes[i];indexes[i]=indexes[j];indexes[j]=temp;
					String stemp=sources[i];sources[i]=sources[j];sources[j]=stemp;
					stemp=targets[i];targets[i]=targets[j];targets[j]=stemp;
				}
			}
		}
		int[] tempindex=new int[indexes.length];
		for(int i=0;i<indexes.length;i++)
			tempindex[i]=indexes[i];
		StringBuilder sb=new StringBuilder(S);
		for(int i=0;i<indexes.length;i++) {
			String temp=S.substring(indexes[i]);
			if(temp.indexOf(sources[i])!=0)
				continue;
			else {
				sb.replace(tempindex[i], tempindex[i]+sources[i].length(), targets[i]);
				for(int j=i+1;j<indexes.length;j++) {
					tempindex[j]+=(targets[i].length()-sources[i].length());
				}
			}
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		String s="frheltogokypgwyoafpp";
		int[] indexes= {15,10,8,5,17,2};
		String[] sources= {"oa","yp","ok","tog","fp","hel"};
		String[] targets= {"fth","ml","vky","fw","k","yzat"};
		System.out.println(findReplaceString(s,indexes,sources,targets));
	}

}
