package com.km.WeeklyContest133;

public class StreamChecker {
    TireNode root = new TireNode();
    StringBuilder sb = new StringBuilder();
    class TireNode{
        public TireNode[] next = new TireNode[26];
        public boolean isword;
    }
    public StreamChecker(String[] words) {

        for(String word:words){
            TireNode temp = root;
            int len = word.length();
            for(int i = len-1;i>=0;i--){
                char c = word.charAt(i);
                if(temp.next[c-'a']==null){
                    temp.next[c-'a'] = new TireNode();
                }
                temp = temp.next[c-'a'];
            }
            temp.isword = true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        TireNode temp = root;
        for(int i = sb.length()-1;i>=0&&temp!=null;i--){
            char c = sb.charAt(i);
            temp = temp.next[c-'a'];
            if(temp!=null&&temp.isword)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"cd","f","kl"};
        StreamChecker test = new StreamChecker(words);
        System.out.println(test.query('a'));
        System.out.println(test.query('b'));
        System.out.println(test.query('c'));
        System.out.println(test.query('d'));
        System.out.println(test.query('e'));
        System.out.println(test.query('f'));
        System.out.println(test.query('g'));
        System.out.println(test.query('h'));
        System.out.println(test.query('i'));
        System.out.println(test.query('j'));
        System.out.println(test.query('k'));
        System.out.println(test.query('l'));

    }
}
