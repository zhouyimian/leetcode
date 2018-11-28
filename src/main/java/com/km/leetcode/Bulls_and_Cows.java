package com.km.leetcode;

public class Bulls_and_Cows {
	public String getHint(String secret, String guess) {
		int[] useA=new int[secret.length()];
		int[] useB=new int[guess.length()];
		int A=0;
		int B=0;
		for(int i=0;i<secret.length();i++) {
			if(secret.charAt(i)==guess.charAt(i)) {
				A++;
				useA[i]=1;
				useB[i]=1;
			}
		}
		for(int i=0;i<secret.length();i++) {
			if(useA[i]==1)
				continue;
			for(int j=0;j<guess.length();j++) {
				if(useB[j]==1)
					continue;
				else if(guess.charAt(j)==secret.charAt(i)) {
					useA[i]=1;
					useB[i]=1;
					B++;
					break;
				}
			}
		}
		return new String(A+"A"+B+"B");
	}
}
