package com.km;

import java.util.*;

public class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<S.length();i++){
            char c = S.charAt(i);
            if(c>='a'&&c<='z'){
                sb.append(c);

            }else if(c>='A'&&c<='Z'){

            }else{
                sb.append(c);
            }
        }
        return ans;
    }

    private void deal(int[][] A, int line, int column) {
        List<Integer> nums = new ArrayList<>();
        int tempLine = line;
        int tempColumn = column;
        while (tempLine>=0&&tempColumn<A.length){
            nums.add(A[tempLine--][tempColumn++]);
        }
        tempLine = line;
        tempColumn = column;
        for(int i = nums.size()-1;i>=0;i--){
            A[tempLine--][tempColumn++]=nums.get(i);
        }
    }


    public static void main(String[] args) {
        Solution test = new Solution();
    }

    private static void function(Solution solution) {
        System.out.println(solution);
    }
}
