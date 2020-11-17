package topic;

import java.util.Arrays;
import java.util.Comparator;

public class A1356_sortByBits {

    public static void main(String[] args) {
        A1356_sortByBits a1356 = new A1356_sortByBits();
        int[] arr = {0,1,2,3,4,5,6,7,8};
        arr = a1356.sortByBits(arr);

        System.out.println(Arrays.toString(arr));
    }

    public int[] sortByBits(int[] arr) {
//        Comparator<Integer> c1 = (i1, i2) -> i1 - i2;
        Comparator<Integer> c1 = (i1, i2) -> {
            int b1 = Integer.bitCount(i1);
            int b2 = Integer.bitCount(i2);
            if(b1 != b2){
                return b1 - b2;
            } else {
                return i1 - i2;
            }
        };
//        Comparator<Integer> c2 = (i1, i2) -> Integer.bitCount(i1) - Integer.bitCount(i2);

        arr = mergeSort(arr, 0, arr.length - 1, c1);
//        arr = mergeSort(arr, 0, arr.length - 1, c2);
        return arr;
    }


    public int[] mergeSort(int[] arr, int left, int right, Comparator<Integer> comparator){
        if(left == right){
            return arr;
        }

        int mid = (left + right)/2;

        int[] leftArr = mergeSort(arr, left, mid, comparator);
        int[] rightArr = mergeSort(arr, mid + 1, right, comparator);

        int l1 = left;
        int r1 = mid + 1;
        int index = left;
        int[] newArr = new int[arr.length];

        while (index < right + 1) {

            if(l1 == mid + 1){
                newArr[index ++] = rightArr[r1 ++];
            } else if(r1 == right + 1) {
                newArr[index ++] = leftArr[l1 ++];
            } else {
                newArr[index ++] = comparator.compare(leftArr[l1], rightArr[r1]) > 0? rightArr[r1 ++] : leftArr[l1 ++];
            }

        }

        return newArr;
    }

}
