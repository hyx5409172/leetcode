package topic;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {8,7,4,3};
        int target = 11;
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        process2(candidates, 0, target, path, ans);

        ans.forEach(System.out::println);
    }



    public static void process(int[] candidates,int index, int target, List<Integer> path, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(index >= candidates.length || candidates[index] > target){
            return;
        }

        // 要
        path.add(candidates[index]);
        process(candidates, index, target - candidates[index], path, ans);
        path.remove((Object) candidates[index]);

        // 不要
        process(candidates, index + 1, target, path, ans);
    }

    public static void process2(int[] candidates, int index, int target, LinkedList<Integer> path, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(index >= candidates.length || candidates[index] > target){
            return;
        }

        // 要
        path.push(candidates[index]);
        process(candidates, index, target - candidates[index], path, ans);
        path.pop();

        // 不要
        process(candidates, index + 1, target, path, ans);
    }



}
