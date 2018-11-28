package com.km.WeeklyContest106;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class three3_Sum_With_Multiplicity {
	public int threeSumMulti(int[] A, int target) {
		int ans=0;
		int[][] left=new int[A.length][101];
		List<HashMap<Integer,Integer>> leftlist=new ArrayList<>();
		List<HashMap<Integer,Integer>> rightlist=new ArrayList<>();
		leftlist.add(new HashMap<Integer,Integer>());
		for(int i=1;i<A.length;i++) {
			HashMap<Integer,Integer> map=new HashMap<>();
			for(int j=0;j<100;j++) {
				left[i][j]=left[i-1][j];
			}
			left[i][A[i-1]]++;
			for(int j=0;j<100;j++) {
				if(left[i][j]!=0)
					map.put(j, left[i][j]);
			}
			leftlist.add(map);
		}
		int[][] right=new int[A.length][101];
		for(int i=0;i<A.length;i++)
			rightlist.add(new HashMap());
		for(int i=A.length-2;i>=0;i--) {
			HashMap<Integer,Integer> map=rightlist.get(i);
			for(int j=0;j<100;j++) {
				right[i][j]=right[i+1][j];
			}
			right[i][A[i+1]]++;
			for(int j=0;j<100;j++) {
				if(right[i][j]!=0)
					map.put(j, right[i][j]);
			}
		}
		for(int i=1;i<A.length;i++) {
			for(int j=0;j<=100;j++) {
				if(leftlist.get(i).containsKey(j)) {
					if(A[i]+j<=target&&rightlist.get(i).containsKey(target-A[i]-j)) {
						int temp=(leftlist.get(i).get(j)*rightlist.get(i).get(target-A[i]-j))%1000000007;
						ans=(ans%1000000007+temp)%1000000007;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A= {1,1,2,2,3,3,4,4,5,5};
		three3_Sum_With_Multiplicity test=new three3_Sum_With_Multiplicity();
		System.out.println(test.threeSumMulti(A, 8));
	}

}
