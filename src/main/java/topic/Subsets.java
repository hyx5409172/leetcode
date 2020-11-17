package topic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 78
 * */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        Stack path = new Stack();
        List ans = new LinkedList();
        process(nums, 0, path, ans);

        ans.forEach(System.out::println);
    }


    public static void process(int[] nums, int index, Stack path, List ans){
        if(index == nums.length){
            ans.add(new ArrayList(path));
            return;
        }

        // 要
        path.push(nums[index]);
        process(nums, index+1, path, ans);
        path.pop();
        // 不要

        process(nums, index+1, path, ans);
    }



}
