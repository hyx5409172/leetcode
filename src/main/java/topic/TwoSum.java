package topic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1
 * */
public class TwoSum {


    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.cacheWay(arr, target)));

    }

    public int[] cacheWay(int[] nums, int target){
        Map<Integer,Integer> cache = new HashMap<>();
        for(int i = 0,length = nums.length; i < length; i ++){
            if(cache.containsKey(target - nums[i]) && cache.get(target - nums[i]) != i){
                return new int[]{i, cache.get(target - nums[i])};
            }
            cache.put(nums[i], i);
        }

        return null;
    }
}
