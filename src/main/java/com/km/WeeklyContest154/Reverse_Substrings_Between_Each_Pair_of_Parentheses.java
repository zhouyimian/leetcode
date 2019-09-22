package com.km.WeeklyContest154;

public class Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public String reverseParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int leftCount = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                int start = i;
                leftCount++;
                i++;
                while (leftCount!=0){
                    if(s.charAt(i)=='(') leftCount++;
                    else if(s.charAt(i)==')')
                        leftCount--;
                    i++;
                }
                StringBuilder temp = new StringBuilder(reverseParentheses(s.substring(start+1,i-1)));
                ans.append(temp.reverse());
                i--;
            }else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Reverse_Substrings_Between_Each_Pair_of_Parentheses t = new Reverse_Substrings_Between_Each_Pair_of_Parentheses();
        System.out.println(t.reverseParentheses("(ed(et(oc))el)"));
    }
}
