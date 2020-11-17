package topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 216
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        int n = 9,k = 3;
        List<List<Integer>> ans = new ArrayList<>();
        process(n, k, 1, new Stack<>(), ans);

        ans.forEach(System.out::println);
    }

    public static void process(int n, int k, int num, Stack<Integer> path, List<List<Integer>> ans) {
        if (0 == k && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (0 == k) {
            return;
        }

        for (int i = num, max = Math.min(9, n); i <= max; i++) {
            path.push(i);
            process(n - i, k - 1, i + 1, path, ans);
            path.pop();
        }

    }


}
