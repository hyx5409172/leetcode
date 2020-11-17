package topic;

import java.util.*;

/**
 * leetCode 40
 * */
public class CombinationSum2 {
    static List<List<Integer>> ans = new LinkedList<>();

    public static void main(String[] args) {
        int[] candidates = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int[] used = new int[candidates.length];
        int target = 27;
        Arrays.sort(candidates);
        process2(candidates, 0,  target, new Stack<>());

        ans.forEach(System.out::println);
    }

    public static void process(int[] candidates, int index, int[] used, int target, Stack<Integer> path){
        System.out.println(path);
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(index >= candidates.length || candidates[index] > target){
            return;
        }

        // 要
        if(!(index > 0 && candidates[index] == candidates[index-1] && used[index-1] != 1)){
            path.push(candidates[index]);
            used[index] = 1;
            process(candidates, index + 1, used, target - candidates[index], path);
            path.pop();
            used[index] = 0;
        }
        // 不要
        process(candidates, index + 1, used, target, path);

    }

    public static void process2(int[] candidates, int index, int target, Stack<Integer> path){
//        System.out.println(path);
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(index >= candidates.length || candidates[index] > target){
            return;
        }

        // 要
        path.push(candidates[index]);
        process2(candidates, index + 1, target - candidates[index], path);
        path.pop();
        // 不要
        int nextNew = index + 1;
        int length = candidates.length;
        while(nextNew < length && candidates[nextNew] == candidates[nextNew - 1]){
            nextNew++;
        }
        process2(candidates, nextNew, target, path);

    }

}
