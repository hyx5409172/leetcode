package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 47
 * */
public class PermuteUnique {

    public static void process (int[] nums, int index, int[] used, int[] path, List ans){
        if(index == nums.length){
            List oneAns = new ArrayList(nums.length);
            for (int i = 0,length = nums.length; i < length; i++) {
                oneAns.add(path[i]);
            }
            ans.add(oneAns);
            return;
        }

        for (int i = 0,length = nums.length; i < length; i++) {
            if(used[i] == 1){
                continue;
            }

            path[index] = nums[i];
            used[i] = 1;
            process(nums, index+1, used, path, ans);
            used[i] = 0;

            while(i + 1 < length && nums[i + 1] == nums[i]){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2};

        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();

        process(nums, 0, new int[nums.length], new int[nums.length], ans);

        ans.forEach(System.out::println);
    }

}
