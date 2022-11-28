package com.neetcode.dsa.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}));
    }

    public boolean isValidSudoku(char[][] board) {

        for(int i =0; i< board.length; i++){
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            for (int j =0; j< board[i].length; j++){
                if(board[i][j] != '.'){
                    if(!row.add(board[i][j])){
                        return false;
                    }
                }
            }
            for (int j =0; j< board.length; j++){
                if(board[j][i] != '.'){
                    if(!col.add(board[j][i])){
                        return false;
                    }
                }
            }
        }

        int q = 0;
        int w = 0;
        for(int k = 0; k<9;k++) {
          Set<Character> boxData = new HashSet<>();
            for (int i = q; i < q + 3; i++) {
                for (int j = w; j < w + 3; j++) {
                    if(board[i][j] != '.'){
                        if(!boxData.add(board[i][j])){
                            return false;
                        }
                    }
                }
            }
            w = w + 3;
            if(w == board.length){
                w = 0;
                q = q + 3;
            }
        }


        return true;
    }
}
