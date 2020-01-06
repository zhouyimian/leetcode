package com.km.WeeklyContest170;

public class Decrypt_String_from_Alphabet_to_Integer_Mapping {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(i+2<s.length()&&Character.isDefined(s.charAt(i))&&Character.isDefined(s.charAt(i+1))&&s.charAt(i+2)=='#'){
                String tempNum = s.charAt(i)+""+s.charAt(i+1);
                sb.append((char) (Integer.parseInt(tempNum)-1+'a'));
                i+=2;
            }else{
                sb.append((char) (Integer.parseInt(s.charAt(i)+"")-1+'a'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((char) (Integer.parseInt('1'+"")+'a'));
        Decrypt_String_from_Alphabet_to_Integer_Mapping test = new Decrypt_String_from_Alphabet_to_Integer_Mapping();
        System.out.println(test.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
