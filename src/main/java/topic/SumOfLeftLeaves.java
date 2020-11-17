package topic;

import common.TreeNode;

public class SumOfLeftLeaves {


    public static int process(TreeNode node){
        int sum = 0;
        if(node.left != null){
            if(node.left.left == null && node.left.right == null){
                sum += node.left.val;
            } else {
                sum += process(node.left);
            }
        }

        if(node.right != null){
            sum += process(node.right);
        }

        return  sum;
    }
}
