package topic;

import common.ArrayToTree;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 113
 * */
public class PathSum {

    public static void main(String[] args) {
        Integer[] arr = {-2,null,-3};
        int sum = -5;
        TreeNode root = ArrayToTree.intArrToTree(arr);


        Stack path = new Stack();
        List ans = new ArrayList();
        process(root, sum, path, ans);
        ans.forEach(System.out::println);
    }

    // Java 文档中 Stack 类建议使用 Deque 代替 Stack，注意：只使用栈的相关接口
    public static void process(TreeNode node, int target, Stack<Integer> path, List ans){
        if(node == null){
            return;
        }

        path.push(node.val);
        if(node.val == target && node.left == null && node.right == null){
            ans.add(new ArrayList(path));
            path.pop();
            return;
        }

        process(node.left, target - node.val, path, ans);
        process(node.right, target - node.val, path, ans);
        path.pop();
    }

}
