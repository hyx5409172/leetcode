package topic;

public class A463_islandPerimeter {


    public int islandPerimeter(int[][] grid) {

        this.grid = grid;
        length1 = grid.length;
        length2 = grid[0].length;
//        used = new int[length1][length2];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if(grid[i][j] == 1){
                    return process(i, j);
                }
            }
        }

        return 0;
    }

    int[][] grid;
//    int[][] used;
    int length1;
    int length2;

    public int process(int i, int j){
        if(i < 0 || i >= length1 || j < 0 || j >= length2 || grid[i][j] == 0){
            return 1;
        }
        if(grid[i][j] == 2){
            return 0;
        }

        int sum = 0;
        grid[i][j] = 2;
        sum += process(i - 1, j);
        sum += process(i + 1, j);
        sum += process(i, j - 1);
        sum += process(i, j + 1);

        return sum;
    }

}
