package topic;

import common.ArrayToTree;
import common.TreeNode;

import java.util.*;

/**
 * leetcode 145
 * */
public class PostorderTraversal {

    public static void main(String[] args) {
        PostorderTraversal p = new PostorderTraversal();
//        Integer[] arr = {1,2,3,4,5,8,null,null,9,6,7,null,null,10,11};
        Integer[] arr = {1,2,3,4,5,6,7,8,null,null,9,null,null,10,11};
        TreeNode root = ArrayToTree.intArrToTree(arr);
        root.lrd(System.out::println);
        System.out.println("program:");
        p.postorderTraversal(root);
        p.postorderTraversal2(root);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Set<TreeNode> processed = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> ans = new LinkedList<>();

        for(TreeNode node = null; !stack.isEmpty();){
            node = stack.pop();
            if(node == null){
                continue;
            }

            if(processed(processed, node.left) && processed(processed, node.right)){
                processed.add(node);
                // doSomething
                ans.add(node.val);
            } else {
                stack.push(node);
                stack.push(node.right);
                stack.push(node.left);
            }

        }

        return ans;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> ans = new LinkedList<>();

        for(TreeNode node = null; !stack.isEmpty();){
            node = stack.pop();
            if(node == null){
                continue;
            }

            if((node.left == null || node.left.val == -1) &&
                    ((node.right == null || node.right.val == -1))){
                // doSomething
                System.out.println(node.val);
                ans.add(node.val);
                node.val = -1;
            } else {
                stack.push(node);
                stack.push(node.right);
                stack.push(node.left);
            }

        }

        return ans;
    }

    public boolean processed(Set<TreeNode> processed, TreeNode node){
        return node == null || processed.contains(node);
    }

}
