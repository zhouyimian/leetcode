package com.km.WeeklyContest154;

public class Maximum_Number_of_Balloons {
    public int maxNumberOfBalloons(String text) {
        char[] temp = new char[26];
        for(int i = 0;i<text.length();i++){
            temp[text.charAt(i)-'a']++;
        }
        int ans = 0;
        while (true){
            if(temp['a'-'a']>0&&temp['b'-'a']>0&&temp['l'-'a']>1&&temp['o'-'a']>1&&temp['n'-'a']>0){
                temp['a'-'a']--;
                temp['b'-'a']--;
                temp['l'-'a']-=2;
                temp['o'-'a']-=2;
                temp['n'-'a']--;
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}
//else{
//                int leftMax = 0;
//                int left = leftMax;
//                int rightMax = 0;
//                int right = rightMax;
//                for(int i = 0;i<arr.length;i++){
//                    right+=arr[i];
//                    rightMax = Math.max(right,rightMax);
//                }
//                for(int i = arr.length-1;i>=0;i--){
//                    left+=arr[i];
//                    leftMax = Math.max(left,leftMax);
//                }
//                ans=Math.max(ans,(k-2)*sum+leftMax+rightMax)%mod;
//                int tempmax = 0;
//                temp = 0;
//                for(int num:arr){
//                    temp+=num;
//                    if(temp>=tempmax){
//                        tempmax = temp;
//                    }
//                    if(temp<0){
//                        temp = 0;
//                    }
//                }
//                ans = Math.max(ans,tempmax);
//                return ans%mod;
//            }
