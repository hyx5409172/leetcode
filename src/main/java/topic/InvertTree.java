package topic;

import common.TreeNode;

import java.util.Stack;

/**
 * leetcode 226
 * */
public class InvertTree {


    public static void nativeWay(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node.left != null){
                stack.push(node);
                node = node.left;
            }

//            node = stack.pop();
//            // 中序 dosomething

            node = node.right;

            node = stack.pop();
            // 中序 dosomething

        }

    }

    public static void invertSon(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void process(TreeNode node){
        if(node == null){
            return;
        }

        process(node.left);
        process(node.right);

        invertSon(node);
    }



}
