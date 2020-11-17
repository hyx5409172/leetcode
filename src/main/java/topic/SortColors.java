package topic;

import java.util.Arrays;

/**
 * leetcode 75
 * */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        SortColors sortColors = new SortColors();

        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int r = 0;
        int b = nums.length - 1;
        int p = 0;
        while(p <= b){
            switch (nums[p]){
                case 0 :
                    if(r == p){
                        p ++;
                    } else {
                        swap(nums, r, p);
                    }
                    r++;
                    break;
                case 1 :
                    p++;
                    break;
                case 2 :
                    if(p == b){
                        p ++;
                    } else {
                        swap(nums, b, p);
                    }
                    b--;
                    break;
            }
        }


    }

    public void swap(int[] arr, int i, int j){
        if(i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }



}
