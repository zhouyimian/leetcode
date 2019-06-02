package com.km.WeeklyContest139;

public class Greatest_Common_Divisor_of_Strings {
    public String gcdOfStrings(String str1, String str2) {
        int length = Math.min(str1.length(),str2.length());
        while(length>0){
            if(str1.length()%length==0&&str2.length()%length==0){
                String temp1 = str1.substring(0,length);
                String temp2 = str2.substring(0,length);
                if(temp1.equals(temp2)){
                    String r1 = str1.replaceAll(temp1,"");
                    String r2 = str2.replaceAll(temp2,"");
                    if(r1.equals("")&&r2.equals(""))
                        return temp1;
                }
            }
            length--;
        }
        return "";
    }

    public static void main(String[] args) {
        Greatest_Common_Divisor_of_Strings test = new Greatest_Common_Divisor_of_Strings();
        System.out.println(test.gcdOfStrings("ABCABC","ABC"));
    }
}
