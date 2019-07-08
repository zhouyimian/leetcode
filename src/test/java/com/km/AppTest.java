package com.km;

public class AppTest {
    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int[] ans = new int[Math.max(num1.length(),num2.length())+1];
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int index = 0;
        while (index1>=0&&index2>=0){
            ans[index++] = c1[index1--]+c2[index2--]-2*'0';
        }
        if(index1>=0){
            while(index1>=0)
                ans[index++] = c1[index1--]-'0';
        }
        else{
            while (index2>=0)
                ans[index++] = c2[index2--]-'0';
        }
        for(int i = 0;i<ans.length-1;i++){
            if(ans[i]>=10) {
                ans[i + 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }
        reverse(ans);
        StringBuilder sb = new StringBuilder();
        if(ans[0]==0){
            for(int i = 1;i<ans.length;i++)
                sb.append(ans[i]+"");
        }
        else{
            for(int num:ans)
                sb.append(num+"");
        }
        return sb.toString();
    }
    public void reverse(int[] ans){
        for(int i = 0;i<ans.length/2;i++){
            int temp = ans[i];
            ans[i] = ans[ans.length-1-i];
            ans[ans.length-1-i] = temp;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AppTest test = new AppTest();
        System.out.println(test.addStrings("9234","867"));
    }
}
