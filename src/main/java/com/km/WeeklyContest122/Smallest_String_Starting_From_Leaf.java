package com.km.WeeklyContest122;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Smallest_String_Starting_From_Leaf {
    List<String> list =new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        int num = 'a'+root.val;
        Character c =(char) num;
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        if(root.left==null&&root.right==null)
            return sb.toString();
        if(root.left!=null)
            search(root.left,new StringBuilder(sb));
        if(root.right!=null)
            search(root.right,new StringBuilder(sb));
        Collections.sort(list);
        return list.get(0);
    }
    public void search(TreeNode root,StringBuilder sb){
        int num = 'a'+root.val;
        Character c =(char) num;
        sb.append(c);
        if(root.left==null&&root.right==null) {
            sb.reverse();
            list.add(new String(sb));
            return;
        }
        if(root.left!=null)
            search(root.left,new StringBuilder(sb));
        if(root.right!=null)
            search(root.right,new StringBuilder(sb));
    }

    public static void main(String[] args) {
        int c = 'a'+1;
        Character s = (char)c;
        System.out.println(s);
    }
}
