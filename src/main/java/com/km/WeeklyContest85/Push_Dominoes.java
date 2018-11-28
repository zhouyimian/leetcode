package com.km.WeeklyContest85;

public class Push_Dominoes {
	public static String pushDominoes(String dominoes) {
		int[] left=new int[dominoes.length()];
		int[] right=new int[dominoes.length()];
		for(int i=0;i<dominoes.length();i++) {
			if(dominoes.charAt(i)!='.')
				continue;
			if(i==0&&dominoes.charAt(0)=='.') {
				left[i]=-1;
			}
			else {
				if(dominoes.charAt(i-1)!='.')
					left[i]=i-1;
				else
					left[i]=left[i-1];
			}
		}
		for(int i=dominoes.length()-1;i>=0;i--) {
			if(dominoes.charAt(i)!='.')
				continue;
			if(i==dominoes.length()-1&&dominoes.charAt(i)=='.')
				right[i]=-1;
			else {
				if(dominoes.charAt(i+1)!='.')
					right[i]=i+1;
				else
					right[i]=right[i+1];
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<dominoes.length();i++) {
			if(dominoes.charAt(i)!='.')
				sb.append(dominoes.charAt(i));
			else {
				int l=left[i];
				int r=right[i];
				if(l==-1&&r==-1)
					sb.append('.');
				else if(l==-1) {
					if(dominoes.charAt(r)=='L')
						sb.append('L');
					else
						sb.append('.');
				}
				else if(r==-1) {
					if(dominoes.charAt(l)=='L')
						sb.append('.');
					else
						sb.append('R');
				}
				else if(dominoes.charAt(l)=='L'&&dominoes.charAt(r)=='L')
					sb.append('L');
				else if(dominoes.charAt(l)=='R'&&dominoes.charAt(r)=='R')
					sb.append('R');
				else if(dominoes.charAt(l)=='L'&&dominoes.charAt(r)=='R')
					sb.append('.');
				else {
					if(i-l==r-i)
						sb.append('.');
					else if(i-l>r-i)
						sb.append('L');
					else
						sb.append('R');
				}
			}
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		System.out.println(pushDominoes(".L.R...LR..L.."));
	}
}
