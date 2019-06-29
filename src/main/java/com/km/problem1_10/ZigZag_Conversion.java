package com.km.problem1_10;

public class ZigZag_Conversion {
    public String convert(String s, int numRows) {
        int line = 0,col = 0;
        char[][] result = new char[numRows][s.length()];
        boolean dire = false;
        if(numRows==1)
            return s;
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[i].length;j++){
                result[i][j] = '$';
            }
        }
        for(int i = 0;i<s.length();i++){
            if(dire){
                while(line>=0&&i<s.length()){
                    result[line][col] = s.charAt(i++);
                    line--;
                    col++;
                }
                line+=2;
                col--;
            }
            else{
                while(line<numRows&&i<s.length()){
                    result[line][col] = s.charAt(i++);
                    line++;
                }
                line-=2;
                col++;
            }
            dire = !dire;
            if(i!=s.length())
                i--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[i].length;j++){
                if(result[i][j]=='$')
                    continue;
                else
                    sb.append(result[i][j]);
            }
        }
        return sb.toString();
    }
}
