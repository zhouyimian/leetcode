package com.km.WeeklyContest110;

public class Reorder_Log_Files {
	public String[] reorderLogFiles(String[] logs) {
		String[] numslogs=new String[logs.length];
		String[] alplogs=new String[logs.length];
		int numscount=0;
		int alpcount=0;
		for(int i=0;i<logs.length;i++) {
			String temp=logs[i].split(" ")[1];
			if(temp.charAt(0)>='0'&&temp.charAt(0)<='9')
				numslogs[numscount++]=new String(logs[i]);
			else
				alplogs[alpcount++]=new String(logs[i]);
		}
		for(int i=0;i<alpcount;i++) {
			for(int j=0;j<alpcount-i-1;j++) {
				String s1=alplogs[j];
				String s2=alplogs[j+1];
				if(s1.substring(s1.split(" ")[0].length()).compareTo(s2.substring(s2.split(" ")[0].length()))>0) {
					exchange(alplogs,j,j+1);
				}
			}
		}
		for(int i=0;i<alpcount;i++)
			logs[i]=new String(alplogs[i]);
		for(int i=0;i<numscount;i++)
			logs[i+alpcount]=new String(numslogs[i]);
		return logs;
	}

	public void exchange(String[] alplogs, int j, int i) {
		String temp=new String(alplogs[j]);
		alplogs[j]=new String(alplogs[i]);
		alplogs[i]=new String(temp);
	}
}
