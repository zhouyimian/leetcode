/**
 * 
 */
package com.km.leetcode;

import java.util.HashMap;
import java.util.Iterator;

public class Evaluate_Division {

	public static void main(String[] args) {
		String[][] equations= { {"a", "e"}, {"b", "e"} };
		double[] values= {4.0,3.0};
		String[][] queries= { {"a", "b"}, {"e", "e"}, {"x", "x"}};
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		int count=0;
		for(int i=0;i<equations.length;i++) {
			for(int j=0;j<equations[i].length;j++) {
				if(hm.containsValue(equations[i][j]))
					continue;
				else {
					hm.put(count++, equations[i][j]);
				}
			}
		}
		String[] record=new String[count];
		for(Integer key:hm.keySet()) {
			String value=hm.get(key);
			record[key]=value;
		}
		double[][] graph=new double[count][count];
		for(int i=0;i<count;i++) {
			for(int j=0;j<count;j++) {
				graph[i][j]=Double.MAX_VALUE;
			}
		}
		for(int i=0;i<equations.length;i++) {
			int from=getKey(equations[i][0],record);
			int to=getKey(equations[i][1],record);
			graph[from][to]=values[i];
			graph[to][from]=1/values[i];
		}
		for(int i=0;i<count;i++) {
			for(int j=0;j<count;j++) {
				for(int k=0;k<count;k++) {
					if (graph[j][k] > graph[j][i] * graph[i][k]) {
						graph[j][k] = graph[j][i] * graph[i][k];
					}
				}
			}
		}
		double[] Ans=new double[queries.length];
		int ans=0;
		for(int i=0;i<queries.length;i++) {
			int from=getKey(queries[i][0],record);
			int to=getKey(queries[i][1],record);
			if(from==-1||to==-1) {
				Ans[ans++]=-1.0;
			}
			else if(from==to) {
				Ans[ans++]=1.0;
			}
			else if(graph[from][to]<Double.MAX_EXPONENT) {
				Ans[ans++]=graph[from][to];
			}
			else if(graph[to][from]<Double.MAX_EXPONENT){
				Ans[ans++]=1/graph[to][from];
			}
			else {
				Ans[ans++]=-1.0;
			}
		}
		for(int i=0;i<Ans.length;i++) {
			System.out.println(Ans[i]);
		}
	}
	static int getKey(String value,String[] s) {
		for(int i=0;i<s.length;i++) {
			if(s[i].equals(value))
				return i;
		}
		return -1;
	}
}
