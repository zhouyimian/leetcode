package com.km.WeeklyContest107;

public class Long_Pressed_Name {
	public boolean isLongPressedName(String name, String typed) {
		if(name==null||typed==null||name.length()>typed.length()||name.charAt(0)!=typed.charAt(0))
			return false;
		if(name.equals(typed))
			return true;
		int i=1,j=1;
		while(i<name.length()&&j<typed.length()) {
			if(name.charAt(i)!=typed.charAt(j)&&typed.charAt(j)!=typed.charAt(j-1))
				return false;
			else if(name.charAt(i)!=typed.charAt(j))
				j++;
			else {
				i++;
				j++;
			}
		}
		if(i>=name.length()&&j>=typed.length())
			return true;
		else if(i>=name.length()) {
			while(j<typed.length()) {
				if(typed.charAt(j)!=typed.charAt(j-1))
					return false;
				j++;
			}
			return true;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		Long_Pressed_Name l=new Long_Pressed_Name();
		System.out.println(l.isLongPressedName("pyplrz", "ppyypllr"));
	}
}
