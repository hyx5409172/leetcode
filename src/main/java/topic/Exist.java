package topic;

/**
 * leetcode 79
 */
public class Exist {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";

        int[][]used = new int[board.length][board[0].length];
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ans = process(board, word, 0, i, j, used);
                if(ans){
                    System.out.println(ans);
                    return ;
                }
            }
        }

        System.out.println(ans);
    }

    public static boolean process(char[][] board, String word, int index, int x, int y, int[][] used) {
        char target = word.charAt(index);
        if (board[x][y] != target) {
            return false;
        }

        if (index == word.length()-1) {
            return true;
        }

        // 对才用
        used[x][y] = 1;

        boolean ans = false;
        if (x + 1 < board.length && used[x + 1][y] == 0) {
            ans = process(board, word, index + 1, x + 1, y, used);
            if(ans){
                return true;
            }
        }

        if (x - 1 >= 0 && used[x - 1][y] == 0) {
            ans = process(board, word, index + 1, x - 1, y, used);
            if(ans){
                return true;
            }
        }

        if (y + 1 < board[0].length && used[x][y + 1] == 0) {
            ans = process(board, word, index + 1, x, y + 1, used);
            if(ans){
                return true;
            }
        }

        if (y - 1 >= 0 && used[x][y - 1] == 0) {
            ans = process(board, word, index + 1, x, y - 1, used);
            if(ans){
                return true;
            }
        }

        used[x][y] = 0;

        return false;
    }

}
