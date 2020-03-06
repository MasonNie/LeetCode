package com.part;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    boolean valid(char[] in){
        boolean flag = true;
        Map<Character,Boolean> map = new HashMap<>();
        for (int i=0;i<in.length;i++){
            if (in[i]=='.') continue;
            if (map.containsKey(in[i])) return false;
            else map.put(in[i],true);
        }

        return flag;
    }

    char [] triple(char [][] board,int row_time,int col_time){
        char []in = new char[9];
        int pos=0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                in[pos++] = board[i+row_time*3][j+col_time*3];
            }
        }
        return in;
    }
    public boolean isValidSudoku(char[][] board) {
        boolean res = true;
        for (int i=0;i<9;i++){
            if(!valid(board[i])) return false;
        }
        for (int i=0;i<9;i++){ // 列
            char in[] = new char[9];
            for (int j=0;j<9;j++){ //行
                in[j] = board[j][i];
            }
            if(!valid(in)) return false;
        }
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                char in[] = new char[9];
                in = triple(board,i,j);
                if(!valid(in)) return false;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char [][] in = {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
        };
        //char[] out = new com.part.ValidSudoku().triple(in,2,2);
        boolean out = new ValidSudoku().isValidSudoku(in);
//        for (int i=0;i<9;i++){
//            System.out.print(out[i]+"\t");
//        }
        System.out.println(out);
    }
}
