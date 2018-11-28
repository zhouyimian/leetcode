package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class word_break {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (wordDict.size() == 0 && (s != null || !s.equals("")))
			return false;
		boolean[] dp = new boolean[s.length()+1];
		s=" "+s;
		dp[0] = true;
		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j < wordDict.size(); j++) {
				int len = wordDict.get(j).length();
				for (int k = 1; k < s.length(); k++) {
					if (k < len ) {
						continue;
					} else {
						String temp = s.substring(k - len+1 , k + 1);
						if (dp[k - len] && temp.equals(wordDict.get(j))) {
							dp[k] = true;
							if (k == s.length()-1)
								return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "leetcode";
		word_break t = new word_break();
		List<String> list = new ArrayList<>();
		list.add("leet");
		list.add("code");
		System.out.println(t.wordBreak(s, list));
	}
}
