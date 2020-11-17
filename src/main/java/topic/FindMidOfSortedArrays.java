package topic;

public class FindMidOfSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {1, 2, 3};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    /**
     * 两数组找到第9小的数字
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int midLeft = (sum-1) / 2;
        int midRight = sum / 2;

        if(nums1.length ==0 || nums2.length==0){
            int[] nonEmptyArr = nums1.length ==0?nums2:nums1;
            return (nonEmptyArr[midLeft] + nonEmptyArr[midRight]) / 2.0;
        }

        int n1Left=-1,n2Left=-1;

        int k = (midLeft+1) / 2;
        while (k > 0){
            if(nums1[Math.min(nums1.length -1, n1Left + k)] >
                    nums2[Math.min(nums2.length -1, n2Left + k)]){
                n2Left = Math.min(nums2.length -1, n2Left + k);
                if(n2Left == nums2.length-1){
                    break;
                }
            } else {
                n1Left = Math.min(nums1.length -1, n1Left + k);
                if(n1Left == nums1.length-1){
                    break;
                }
            }

            k /= 2;
        }

        if(n1Left == nums1.length-1 || n2Left == nums2.length-1){
            int[] survivor = n1Left == nums1.length-1?nums2:nums1;
            int[] victim = survivor == nums1?nums2:nums1;
            return (survivor[midLeft - victim.length] + survivor[midRight - victim.length])/2.0;
        }

        if(midLeft == midRight){
            return Math.min(nums1[n1Left + 1], nums2[n2Left + 1]);
        } else {
            int left = Math.min(nums1[n1Left + 1], nums2[n2Left + 1]);
            int lp = left == nums1[n1Left + 1]? n1Left + 1 : n2Left + 1;
            int rp = left == nums1[n1Left + 1]? n2Left : n1Left;
            int[] larr = left == nums1[n1Left + 1]? nums1 : nums2;
            int[] rarr = left == nums1[n1Left + 1]? nums2 : nums1;

            int right = Math.min(lp + 1>larr.length-1?Integer.MAX_VALUE:larr[lp + 1],
                    rp + 1>rarr.length-1?Integer.MAX_VALUE:rarr[rp + 1]);

            return (left + right)/ 2.0;
        }
    }

}
