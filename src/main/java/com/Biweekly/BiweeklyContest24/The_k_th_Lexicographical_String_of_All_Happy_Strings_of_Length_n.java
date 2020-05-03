package com.Biweekly.BiweeklyContest24;

public class The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n {
    public String getHappyString(int n, int k) {
        int[][] dp = new int[n+1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for(int i = 2;i<=n;i++){
            dp[i][0] = dp[i-1][1]+dp[i-1][2];
            dp[i][1] = dp[i-1][0]+dp[i-1][2];
            dp[i][2] = dp[i-1][0]+dp[i-1][1];
        }
        if((dp[n][0]+dp[n][1]+dp[n][2])<k)
            return "";
        StringBuilder ans = new StringBuilder();
        for(int i = n;i>=1;i--){
            for(int j = 0;j<=2;j++){
                if(dp[i][j]>=k){
                    if(ans.length()==0) {
                        ans.append((char) ('a' + j));
                        break;
                    }else{
                        char c = (char) ('a' + j);
                        if(c==ans.charAt(ans.length()-1))
                            ans.append((char) ('a' + j+1));
                        else
                            ans.append((char) ('a' + j));
                        break;
                    }
                }else{
                    k-=dp[i][j];
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n test = new The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n();
        System.out.println(test.getHappyString(10,100));
    }
}
