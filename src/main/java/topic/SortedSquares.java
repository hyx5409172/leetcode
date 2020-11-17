package topic;

import java.util.Arrays;
/**
 * leetcode 977
 * */
public class SortedSquares {


    public static void main(String[] args) {
        int[] A = {-2,0};
        SortedSquares sq = new SortedSquares();

        System.out.println(Arrays.toString(sq.sortedSquares(A)));
    }

    /**
     * 双指针从两头开始会更好一些
     * */
    public int[] sortedSquares(int[] A) {
        int[] sq = new int[A.length];
        int cor = -1;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            sq[i] = A[i] * A[i];
            if(cor == -1 && i > 0 && sq[i] > sq[i-1] ){
                cor = i - 1;
            }
        }

        int[] sorted = new int[A.length];
        // 趋势单一
        if(cor == -1){
            if(sq[length-1] > sq[0]){
                return sq;
            }
            return reverse(sq);
        }
        int left = cor - 1;
        int right = cor + 1;

        sorted[0] = sq[cor];
        for (int i = 1; i < length; i++) {
            int smallIndex = left;

            if (left < 0){
                smallIndex = right++;
            } else if (right > length - 1){
                smallIndex = left--;
            } else {
                if(sq[right] > sq[left]){
                    smallIndex = left;
                    left --;
                } else {
                    smallIndex = right;
                    right ++;
                }
            }

            sorted[i] = sq[smallIndex];
        }

        return  sorted;
    }

    public int[] reverse(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(right > left){
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
            left ++;
            right --;
        }

        return arr;
    }
}
