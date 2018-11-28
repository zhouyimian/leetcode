package com.km.leetcode;

public class Decode_String {
	public static String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		sb = buildString(s);
		return new String(sb);
	}

	static StringBuilder buildString(String s) {
		if(s.length()==0)
			return new StringBuilder();
		if(s.indexOf('[')==-1)
			return new StringBuilder(s);
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int num = 1;
		int flag = 0;
		if (!(s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
			for (start = 0;start<s.length(); start++) {
				char c = s.charAt(start);
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
					sb.append(c);
				else
					break;
			}
		}
		for (int i = s.indexOf('[') + 1; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				num++;
				flag = 1;
			} else if (s.charAt(i) == ']') {
				num--;
				if (num == 0) {
					int count = Integer.parseInt(s.substring(start, s.indexOf('[')));
					if (flag == 0) {
						for (int j = 0; j < count; j++) {
							sb.append(s.substring(s.indexOf('[') + 1, i));
						}
					} else {
						StringBuilder temp = buildString(s.substring(s.indexOf('[') + 1, i));
						for (int j = 0; j < count; j++)
							sb.append(temp);
						flag = 1;
					}
					s = s.substring(i + 1);
					sb.append(buildString(s));
					break;
				}
			}
		}
		return sb;
	}

	public static void main(String[] args) {
		System.out.println(decodeString("2[a]3[b]4[c]"));
	}
}
