package com.km.WeeklyContest177;

public class Validate_Binary_Tree_Nodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] in = new int[n];
        for(int i = 0;i<n;i++){
            if(leftChild[i]!=-1)
                in[leftChild[i]]++;
            if(rightChild[i]!=-1)
                in[rightChild[i]]++;
        }
        int rootVal = -1;
        for(int i = 0;i<n;i++){
            if(in[i]==0){
                if(rootVal==-1){
                    rootVal = i;
                }else{
                    return false;
                }
            }
            if(in[i]>1)
                return false;
        }
        return rootVal!=-1;
    }
}
