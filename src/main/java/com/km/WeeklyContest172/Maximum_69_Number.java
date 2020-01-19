package com.km.WeeklyContest172;

public class Maximum_69_Number {
    public int maximum69Number (int num) {

        StringBuilder sb = new StringBuilder(num+"");
        for(int i = 0;i<sb.length();i++){
            if(sb.charAt(i)=='6'){
                sb.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Maximum_69_Number test = new Maximum_69_Number();
        System.out.println(test.maximum69Number(9669));
    }
}
