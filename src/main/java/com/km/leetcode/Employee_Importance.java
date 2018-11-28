package com.km.leetcode;

import java.util.*;

class Employee {
    
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
public class Employee_Importance {
	Map<Integer,Employee> map;
	public int getImportance(List<Employee> employees, int id) {
        map=new HashMap<>();
        for(int i=0;i<employees.size();i++){
            map.put(employees.get(i).id, employees.get(i));
        }
        List<Integer> list=map.get(id).subordinates;
        int ans=map.get(id).importance;
        for(int i=0;i<list.size();i++)
        	ans+=Search(map.get(list.get(i)));
        return ans;
    }
	int Search(Employee employee) {
		List<Integer> list=map.get(employee.id).subordinates;
        int ans=map.get(employee.id).importance;
        for(int i=0;i<list.size();i++)
        	ans+=Search(map.get(list.get(i)));
		return ans;
	}
}
