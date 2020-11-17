package topic;

public class MaxArea {




    /**
     * no dp way 此题解法不在于递归
     * */
//    public static int dpWay(int[] height){
//        int[] dp = new int[height.length];
//        dp[height.length - 1] = 0;
//
//        for (int i = height.length - 1; i > -1 ; i--) {
//            dp[i] =
//
//
//        }
//
//
//        return dp[0];
//    }


    public static int process(int[] height, int leftIndex){
        if(leftIndex >= height.length - 1){
            return 0;
        }

        int maxArea = 0;
        for (int i = leftIndex + 1; i < height.length; i++) {
            maxArea = Math.max(maxArea, Math.min(height[leftIndex], height[i]) * (i - leftIndex));
        }

        maxArea = Math.max(maxArea, process(height, leftIndex + 1));
        return maxArea;
    }


}
