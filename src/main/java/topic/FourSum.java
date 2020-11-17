package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 18
 * */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        FourSum fourSum = new FourSum();

        // begin
//        Arrays.sort(nums);
//        int min = 0;
//        if(nums.length > 1){
//            min = nums[0];
//            for (int i = 0, length = nums.length; i < length; i++) {
//                nums[i] -= min;
//            }
//
//            for (int i = 0; i < 4; i++) {
//                target -= min;
//            }
//        }
//        Stack<Integer> path = new Stack<>();
//        List<List<Integer>> ans = new ArrayList<>();
//        fourSum.process(nums, 0, target, path, ans, min);
//        ans.forEach(System.out::println);

        // way2
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        fourSum.doublePointer(nums, target, ans, 0);
        ans.forEach(System.out::println);
    }

    // 1884 ms
    public void process(int[] nums, int index, int target, Stack<Integer> path , List<List<Integer>> ans, int min){
        if(target == 0 && path.size() == 4){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(index == nums.length || path.size() == 4){
            return;
        }

        // 剪枝
        if(nums[index] > target){
            return;
        }

        // 要
        path.push(nums[index] + min);
        process(nums, index + 1, target - nums[index], path, ans, min);
        path.pop();

        // 不要
        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index ++;
        }
        process(nums, index + 1, target, path, ans, min);

    }

    // 未剪枝 42ms
    public void doublePointer(int[] nums, int target, List<List<Integer>> ans, int min){
        if(nums.length < 4){
            return;
        }
        Stack<Integer> tempAns = new Stack<>();

        for (int i = 0,length = nums.length; i < length - 3;) {
            tempAns.push(nums[i]);
            for (int j = i + 1; j < length - 2;) {
                tempAns.push(nums[j]);
                int p1 = j + 1;
                int p2 = length - 1;
                int tempTarget = target - nums[i] - nums[j];

                while(p2 > p1){
                    int res = nums[p1] + nums[p2] - tempTarget;
                    if(res == 0){
                        tempAns.push(nums[p1]);
                        tempAns.push(nums[p2]);
                        ans.add(new ArrayList<>(tempAns));
                        tempAns.pop();
                        tempAns.pop();
                        p2 = movePointer(nums, p2, false);
                        p1 = movePointer(nums, p1, true);
                    } else if(res < 0){
                        p1 = movePointer(nums, p1, true);
                    } else {
                        p2 = movePointer(nums, p2, false);
                    }
                }

                j = movePointer(nums, j, true);
                tempAns.pop();
            }

            i = movePointer(nums, i, true);
            tempAns.pop();
        }

    }

    public int movePointer(int[] nums, int index, boolean toRight){
        if(toRight){
            while(index < nums.length - 1 && nums[index] == nums[index + 1]){
                index ++;
            }
            index ++;
            return index;
        }
        while(index > 0 && nums[index - 1] == nums[index]){
            index --;
        }
        index --;
        return  index ;
    }

}
