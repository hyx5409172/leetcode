package topic;

import common.TreeNode;

import java.util.*;

/**
 * leetcode 538
 * */
public class ConvertBST2GreaterTree {



    public static void nativeWay(TreeNode node){

        List<TreeNode> nodes = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode tempNode = null;
        while(!stack.isEmpty()){
            tempNode = stack.pop();
            if(tempNode.left != null){
                stack.push(tempNode.left);
            }

            if(tempNode.right != null){
                stack.push(tempNode.right);
            }

            nodes.add(tempNode);
        }

        nodes.sort((t1, t2) -> t2.val - t1.val);

        TreeNode preNode = null;
        TreeNode nextNode= null;
        for (int i = 0,size = nodes.size(); i < size; i++) {
            if(i > 0){
                preNode = nodes.get(i-1);
                node = nodes.get(i);
                nextNode = i+1<size?nodes.get(i + 1):null;
                while (nextNode!=null && nextNode.val == node.val) {
                    nextNode.val += preNode.val;
                    i++;
                    nextNode = i+1<size?nodes.get(i + 1):null;
                }

                node.val += preNode.val;
            }
        }
    }


    public static int process(TreeNode node, int curSum) {
        if (node == null) {
            return curSum;
        }

        curSum = process(node.right, curSum);

        node.val += curSum;
        curSum = node.val;

        curSum = process(node.left, curSum);

        return curSum;
    }

}
