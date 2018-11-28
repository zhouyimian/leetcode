package com.km.leetcode;

public class Similar_RGB_Color {
	public static String similarRGB(String color) {
		int diff=Integer.MAX_VALUE;
		int ans_first = 0,ans_mid=0,ans_last=0;
		int str_first=Integer.parseInt(color.substring(1,3), 16);
		int str_mid=Integer.parseInt(color.substring(3,5), 16);
		int str_last=Integer.parseInt(color.substring(5,7), 16);
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				for(int k=0;k<16;k++) {
					int count=(int) (Math.pow((i*17-str_first), 2)+Math.pow((j*17-str_mid), 2)+Math.pow((k*17-str_last), 2));
					if(count<diff) {
						diff=count;
						ans_first=i;
						ans_mid=j;
						ans_last=k;
					}
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		if(ans_first<10) {
			sb.append(ans_first+""+ans_first);
		}
		else {
			sb.append((char)(ans_first-10+'a'));
			sb.append((char)(ans_first-10+'a'));
		}
		if(ans_mid<10) {
			sb.append(ans_mid+""+ans_mid);
		}
		else {
			sb.append((char)(ans_mid-10+'a'));
			sb.append((char)(ans_mid-10+'a'));
		}
		if(ans_last<10) {
			sb.append(ans_last+""+ans_last);
		}
		else {
			sb.append((char)(ans_last-10+'a'));
			sb.append((char)(ans_last-10+'a'));
		}
			
		
		return new String("#"+sb);
	}
	public static void main(String[] args) {
		System.out.println(similarRGB("#09f166"));
	}
}
