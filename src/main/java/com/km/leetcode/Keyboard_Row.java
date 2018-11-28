package com.km.leetcode;

public class Keyboard_Row {
	public static String[] findWords(String[] words) {
		if (words.length == 0)
			return new String[0];
		int flag = 0;
		String ans = "";
		int thing;
		for (int i = 0; i < words.length; i++) {
			char c = words[i].charAt(0);
			if (c == 'Q' || c == 'q' || c == 'w' || c == 'W' || c == 'E' || c == 'e' || c == 'R' || c == 'r' || c == 'T'
					|| c == 't' || c == 'Y' || c == 'y' || c == 'U' || c == 'u' || c == 'I' || c == 'i' || c == 'O'
					|| c == 'o' || c == 'P' || c == 'p') {
				thing = 1;
			} else if (c == 'A' || c == 'a' || c == 'S' || c == 's' || c == 'D' || c == 'd' || c == 'F' || c == 'f'
					|| c == 'G' || c == 'g' || c == 'H' || c == 'h' || c == 'J' || c == 'j' || c == 'K' || c == 'k'
					|| c == 'L' || c == 'l') {
				thing = 2;
			} else {
				thing = 3;
			}
			if (thing == 1) {
				for (int j = 0; j < words[i].length(); j++) {
					c = words[i].charAt(j);
					if (c == 'Q' || c == 'q' || c == 'w' || c == 'W' || c == 'E' || c == 'e' || c == 'R' || c == 'r'
							|| c == 'T' || c == 't' || c == 'Y' || c == 'y' || c == 'U' || c == 'u' || c == 'I'
							|| c == 'i' || c == 'O' || c == 'o' || c == 'P' || c == 'p') {
						continue;
					} else {
						flag = 1;
						break;
					}
				}
			} else if (thing == 2) {
				for (int j = 0; j < words[i].length(); j++) {
					c = words[i].charAt(j);
					if (c == 'A' || c == 'a' || c == 'S' || c == 's' || c == 'D' || c == 'd' || c == 'F' || c == 'f'
							|| c == 'G' || c == 'g' || c == 'H' || c == 'h' || c == 'J' || c == 'j' || c == 'K'
							|| c == 'k' || c == 'L' || c == 'l') {
						continue;
					} else {
						flag = 1;
						break;
					}
				}
			} else {
				for (int j = 0; j < words[i].length(); j++) {
					c = words[i].charAt(j);
					if (c == 'Z' || c == 'z' || c == 'X' || c == 'x' || c == 'C' || c == 'c' || c == 'V' || c == 'v'
							|| c == 'B' || c == 'b' || c == 'N' || c == 'n' || c == 'M' || c == 'm') {
						continue;
					} else {
						flag = 1;
						break;
					}
				}
			}
			if (flag == 0) {
				ans = ans + words[i] + " ";
			} else {
				flag = 0;
			}
		}
		String[] Ans = ans.split(" ");
		if(ans.equals(""))
			return new String[0];
		Ans=ans.split(" ");
		return Ans;
	}
	public static void main(String[] args) {
		String[] s= {"asdqwe","qweqweasd"};
		findWords(s);
	}
}
