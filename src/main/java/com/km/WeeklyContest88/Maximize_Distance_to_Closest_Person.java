package com.km.WeeklyContest88;

public class Maximize_Distance_to_Closest_Person {
	public static int maxDistToClosest(int[] seats) {
		int[] left=new int[seats.length];
		int[] right=new int[seats.length];
		int max=0;
		int pos=0;
		for(int i=0;i<seats.length;i++) {
			if(seats[i]==1)
				left[i]=0;
			else if(i!=0)
				left[i]=left[i-1]+1;
			else
				left[i]=1;
		}
		for(int i=seats.length-1;i>=0;i--) {
			if(seats[i]==1)
				right[i]=0;
			else if(i!=seats.length-1)
				right[i]=right[i+1]+1;
			else
				right[i]=1;
		}
		for(int i=1;i<seats.length-2;i++) {
			int leftdis=left[i]%2==1?left[i]/2+1:left[i]/2;
			int rightdis=right[i]%2==1?right[i]/2+1:right[i]/2;
			max=Math.max(max, leftdis>rightdis?leftdis:rightdis);
		}
		int count=1;
		if(seats[0]==0) {
			for(int i=1;i<seats.length&&seats[i]==0;i++)
				count++;
		}
		max=Math.max(count, max);
		count=1;
		if(seats[seats.length-1]==0) {
			for(int i=seats.length-2;i>=0&&seats[i]==0;i--)
				count++;
		}
		max=Math.max(count, max);
		return max;
	}
	public static void main(String[] args) {
		int[] s= {1,0,0,0};
		System.out.println(maxDistToClosest(s));
	}
}
