package com.km.WeeklyContest108;

import java.util.HashSet;
import java.util.Set;

public class Unique_Email_Addresses {
	public int numUniqueEmails(String[] emails) {
		Set<String> set=new HashSet<>();
		for(int i=0;i<emails.length;i++) {
			StringBuilder sb=new StringBuilder();
			String yuming=emails[i].substring(emails[i].indexOf('@'));
			String username=emails[i].substring(0,emails[i].indexOf('@'));
			username=username.replaceAll("\\.", "");
			int first_index=username.indexOf("+");
			if(first_index==-1) {
				sb.append(username).append(yuming);
				set.add(new String(sb));
			}
			else {
				String temp=username.substring(0,first_index);
				sb.append(temp).append(yuming);
				set.add(new String(sb));
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		Unique_Email_Addresses test=new Unique_Email_Addresses();
		String[] s= {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(test.numUniqueEmails(s));
		
	}

}
