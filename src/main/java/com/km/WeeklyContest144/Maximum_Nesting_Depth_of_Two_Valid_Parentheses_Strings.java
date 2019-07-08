package com.km.WeeklyContest144;

public class Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        int max_depth = 0;
        for(int i = 0;i<seq.length();i++){
            if(seq.charAt(i)=='(') max_depth = Math.max(++depth,max_depth);
            else depth--;
        }
        int half = max_depth/2;
        depth = 0;
        for(int i = 0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                depth++;
                if(depth>half)
                    ans[i] = 1;
            }
            else{
                if(depth>half)
                    ans[i] = 1;
                depth--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings test = new Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings();
        int[] ans = test.maxDepthAfterSplit("(()())");
        for(int num:ans)
            System.out.println(num);
    }
}
