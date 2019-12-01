package com.km.WeeklyContest165;

public class Find_Winner_on_a_Tic_Tac_Toe_Game {
    public String tictactoe(int[][] moves) {
        int[][] graph = new int[3][3];
        for(int i = 0;i<moves.length;i++){
            if(i%2==0)
                graph[moves[i][0]][moves[i][1]] = 1;
            else
                graph[moves[i][0]][moves[i][1]] = 2;
        }
        if((graph[0][0]==graph[0][1]&&graph[0][1]==graph[0][2])){
            if(graph[0][0]==1)
                return "A";
            else if(graph[0][0]==2)
                return "B";
        }
        if((graph[1][0]==graph[1][1]&&graph[1][1]==graph[1][2])){
            if(graph[1][0]==1)
                return "A";
            else if(graph[1][0]==2)
                return "B";
        }
        if((graph[2][0]==graph[2][1]&&graph[2][1]==graph[2][2])){
            if(graph[2][0]==1)
                return "A";
            else if(graph[2][0]==2)
                return "B";
        }
        if((graph[0][0]==graph[1][0]&&graph[1][0]==graph[2][0])){
            if(graph[0][0]==1)
                return "A";
            else if(graph[0][0]==2)
                return "B";
        }
        if((graph[0][1]==graph[1][1]&&graph[1][1]==graph[2][1])){
            if(graph[0][1]==1)
                return "A";
            else if(graph[0][1]==2)
                return "B";
        }
        if((graph[0][2]==graph[1][2]&&graph[1][2]==graph[2][2])){
            if(graph[0][2]==1)
                return "A";
            else if(graph[0][2]==2)
                return "B";
        }
        if((graph[0][0]==graph[1][1]&&graph[1][1]==graph[2][2])){
            if(graph[0][0]==1)
                return "A";
            else if(graph[0][0]==2)
                return "B";
        }
        if((graph[0][2]==graph[1][1]&&graph[1][1]==graph[2][0])){
            if(graph[0][2]==1)
                return "A";
            else if(graph[0][2]==2)
                return "B";
        }
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(graph[i][j]==0)
                    return "Pending";
            }
        }
        return "Draw";
    }
}
