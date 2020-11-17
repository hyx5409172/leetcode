package topic;

/**
 * leetcode 52
 * */
public class TotalNQueens {

    public static void main(String[] args) {
        TotalNQueens totalNQueens = new TotalNQueens();
        int n = 4;

        System.out.println(totalNQueens.totalNQueens(n));
    }

    public int totalNQueens(int n) {
        return process(n, 0, new int[n]);
    }


    public int process(int n, int index, int[] queens){
        int ans = 0;

        // base case
        if(index == n){
            return 1;
        }

        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < index; j++) {
                if(i == index - j + queens[j]
                        || i == j + queens[j] - index
                        || i == queens[j]){
                    continue outer;
                }
            }

            queens[index] = i;
            ans += process(n, index + 1, queens);
        }

        return  ans;
    }


}
