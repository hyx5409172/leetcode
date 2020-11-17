package topic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leet code 416
 * */
public class CanPartition {

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};

        System.out.println(canPartition.canPartition(nums));
    }

    Map<String, Boolean> cache = new HashMap<>();
    int[] subSum = null;
    int sum = 0;
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length < 2){
            return  false;
        }

        Arrays.sort(nums);
        subSum = new int[nums.length];
        for (int i = 0,length = nums.length; i < length; i++) {
            sum += nums[i];
            subSum[i] = sum;
        }

        if(sum % 2 != 0){
            return false;
        }


        int target = sum/2;

//        return process(nums, 0, target);
        return dpWay(nums);
    }



    public boolean process(int[] nums, int index, int target){
        int otherTarget = sum - target - (index > 0?subSum[index-1]:0);

        if(index == nums.length && target ==0 && otherTarget == 0){
            return true;
        }

        String key1 = index + "-" + target + "-" + otherTarget;
        String key2 = index + "-" + otherTarget + "-" + target;
        if(cache.containsKey(key1)){
            return cache.get(key1);
        }

        boolean res = false;
        boolean goOn = true;
        // 有一个到不了0，直接返回
        if((target != 0 && nums[index] > target)
                || (otherTarget != 0 && nums[index] > otherTarget)){
            goOn = false;
        }
        // 给左集
        if(goOn && target != 0){
            res = process(nums, index + 1, target - nums[index]);
            if(res){
                goOn = false;
            }
        }

        // 给右集
        if(goOn && otherTarget != 0){
            res = process(nums, index + 1, target);
        }

        cache.put(key1, res);
        cache.put(key2, res);
        return res;
    }

    public boolean dpWay(int[] nums){
        int[][] dp = new int[nums.length + 1][sum/2 + 1];
        dp[nums.length][0] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {

            // 这里不能加，会溢出，导致最后判断错误
            for (int j = 0; j <= sum/2; j++) {
                dp[i][j] |= dp[i + 1][j];
                if(j - nums[i] >= 0){
                    dp[i][j] |= dp[i + 1][j - nums[i]];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[0][sum/2] > 0;
    }


}
