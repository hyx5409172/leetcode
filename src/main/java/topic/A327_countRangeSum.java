package topic;

/**
 * 困难题，官方给处5个解
 * */
public class A327_countRangeSum {

    public static void main(String[] args) {
        A327_countRangeSum a327 = new A327_countRangeSum();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int[] nums = {-2147483647,0,-2147483647,2147483647};
        int lower = -564;
        int upper = 3864;

        System.out.println(a327.countRangeSum(nums, lower, upper));

    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        return n2way(nums, lower, upper);

    }

    // n^2复杂度，请优化
    public int n2way(int[] nums, int lower, int upper){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum >= lower && sum <= upper){
                    count++;
                    System.out.println("i: " + i + " j: " + j);
                }
            }
        }

        return count;
    }


}
