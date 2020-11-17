package topic;

import java.util.Arrays;

public class A349_intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int[] res = new int[nums1.length > nums2.length? nums2.length : nums1.length];
        int size = 0;

        while (i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                res[size ++] = nums1[i];
                i = nextDiffer(nums1, i);
                j = nextDiffer(nums2, j);
            } else if (nums1[i] > nums2[j]){
                j = nextDiffer(nums2, j);
            } else {
                i = nextDiffer(nums1, i);
            }
        }

        int[] ans = new int[size];
        for (int k = 0; k < size; k++) {
            ans[k] = res[k];
        }

        return ans;
    }

    public int nextDiffer(int[] arr, int i){
        while(i + 1 < arr.length && arr[i] == arr[i + 1]){
            i ++;
        }

        return i + 1;
    }

}
