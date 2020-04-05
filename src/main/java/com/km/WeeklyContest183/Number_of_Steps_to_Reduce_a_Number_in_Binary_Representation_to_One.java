package com.km.WeeklyContest183;

public class Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int ans = 0;
        if(sb.length()==1)
            return 0;
        while (sb.length()!=1){
            ans++;
            if(sb.charAt(sb.length()-1)=='0'){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.setCharAt(sb.length()-1,'0');
                deal(sb);
            }
        }
        return ans;
    }

    private void deal(StringBuilder sb) {
        for(int i = sb.length()-2;i>=0;i--){
            if(sb.charAt(i)=='0'){
                sb.setCharAt(i,'1');
                return;
            }else{
                sb.setCharAt(i,'0');
            }
        }
        if(sb.charAt(0)=='0')
            sb.insert(0,'1');
    }

    public static void main(String[] args) {
        Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One test = new Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One();
        System.out.println(test.numSteps("10"));
    }
}
