package com.km.WeeklyContest147;

import java.util.ArrayList;
import java.util.List;

public class Alphabet_Board_Path {
    class Node{
        int x;
        int y;
        String curPath;
        public Node(int x,int y,String curPath){
            this.x = x;
            this.y = y;
            this.curPath = curPath;
        }
    }
    public String alphabetBoardPath(String target) {
        int[][] dire = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
        String[] UDLR = {"!","U","D","L","R"};
        String ans = null;
        List<Node> queue = new ArrayList<>();
        String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        int count = 0;
        if(target.length()==0)
            return "";
        else{
            queue.add(new Node(0,0,""));
            while (queue.size()!=0){
                boolean[][] vis = new boolean[6][5];
                List<Node> temp = new ArrayList<>();
                for(int i = 0;i<queue.size();i++){
                    Node cur = queue.get(i);
                    for(int j = 0;j<5;j++){
                        int x = dire[j][0] + cur.x;
                        int y = dire[j][1] + cur.y;
                        if(check(x,y,board,vis)){
                            vis[x][y] = true;
                            String newPath = cur.curPath;
                            if(board[x].charAt(y)==target.charAt(count)){
                                if(j==0){
                                    newPath+="!";
                                    count++;
                                }else{
                                    newPath+=UDLR[j];
                                    newPath+="!";
                                    count++;
                                }
                                queue.clear();
                                temp.clear();
                                temp.add(new Node(x,y,newPath));
                                break;
                            }else{
                                newPath+=UDLR[j];
                                temp.add(new Node(x,y,newPath));
                            }
                        }
                    }
                }
                if(count==target.length()) {
                    ans = temp.get(0).curPath;
                    break;
                }
                queue.clear();
                queue.addAll(temp);
            }
        }
        return ans;
    }

    private boolean check(int x, int y, String[] board,boolean[][] vis) {
        if(x<0||y<0||x>=board.length||y>=board[x].length()||vis[x][y])
            return false;
        return true;
    }

    public static void main(String[] args) {
        Alphabet_Board_Path test = new Alphabet_Board_Path();

        System.out.println(test.alphabetBoardPath("code"));
    }
}
