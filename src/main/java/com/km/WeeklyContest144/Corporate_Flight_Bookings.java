package com.km.WeeklyContest144;

public class Corporate_Flight_Bookings {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int start;
        int end;
        int num;
        public TreeNode(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    int[] ans;
    public int[] corpFlightBookings(int[][] bookings, int n) {
        TreeNode root = buildTree(1,n);
        for(int i = 0;i<bookings.length;i++){
            addNum(root,bookings[i][0],bookings[i][1],bookings[i][2]);
        }
        ans = new int[n];
        dfs(root,0,n);
        return ans;
    }
    public void dfs(TreeNode root,int cur,int n){
        if(root.start==root.end){
            ans[root.start-1] = cur+root.num;
            return;
        }else{
            dfs(root.left,cur+root.num,n);
            dfs(root.right,cur+root.num,n);
        }
    }
    public TreeNode buildTree(int start,int end){
        TreeNode root = new TreeNode(start,end);
        if(start<end){
            int mid = start + (end-start)/2;
            root.left = buildTree(start,mid);
            root.right = buildTree(mid+1,end);
        }
        return root;
    }
    public void addNum(TreeNode root,int start,int end,int num){
         if(root.start==start&&root.end==end){
            root.num += num;
            return;
        }else{
            int mid = root.start + (root.end-root.start)/2;
            if(end<=mid){
                addNum(root.left,start,end,num);
            }else if(mid<start){
                addNum(root.right,start,end,num);
            }else{
                addNum(root.left,start,mid,num);
                addNum(root.right,mid+1,end,num);
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{2,2,35},{2,2,10}};
        Corporate_Flight_Bookings test = new Corporate_Flight_Bookings();
        int[] ans = test.corpFlightBookings(nums,2);
        for(int num:ans)
            System.out.println(num);
    }
}
