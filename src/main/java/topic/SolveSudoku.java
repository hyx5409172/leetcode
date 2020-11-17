package topic;

import java.util.Arrays;

/**
 * leetcode 37
 * */
public class SolveSudoku {


    public static void main(String[] args) {
        char [][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        char[][] rowUsed = new char[9][10], colUsed = new char[9][10];
        char[][][] blockUsed = new char[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    rowUsed[i][board[i][j] - '0'] = 1;
                    colUsed[j][board[i][j] - '0'] = 1;
                    blockUsed[i/3][j/3][board[i][j] - '0'] = 1;
                }
            }
        }

        process(board, 0, 0, rowUsed, colUsed, blockUsed);

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }


    public static char[][] process(char[][] board, int row, int col,
                               char[][] rowUsed, char[][] colUsed, char[][][] blockUsed){

        if(row == 9){
            return  board;
        }

        if(board[row][col] == '.'){
            for (int i = 1; i < 10; i++) {
                if(rowUsed[row][i] == 1 ||
                    colUsed[col][i] == 1 ||
                        blockUsed[row/3][col/3][i] == 1){
                    continue;
                }

                // 当前i可用
                rowUsed[row][i] = 1;
                colUsed[col][i] = 1;
                blockUsed[row/3][col/3][i] = 1;
                board[row][col] = (char) (i + '0');

                int nextRow = col == 8? row + 1 : row;
                int nextCol = col == 8? 0 : col + 1;
                char[][] ans = process(board, nextRow, nextCol, rowUsed, colUsed, blockUsed);
                // 有结果直接返回
                if(ans != null){
                    return ans;
                }

                rowUsed[row][i] = 0;
                colUsed[col][i] = 0;
                blockUsed[row/3][col/3][i] = 0;
                board[row][col] = '.';


            }

            // 填啥都不行 返回null
            return null;
        }

//        // 当前不需要填
        int nextRow = col == 8? row + 1 : row;
        int nextCol = col == 8? 0 : col + 1;
        return process(board, nextRow, nextCol, rowUsed, colUsed, blockUsed);

    }

}
