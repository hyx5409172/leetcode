package topic;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 637
 */
public class AverageOfLevels {

    public static List<Double> nativeWay(TreeNode root){
        List<Double> ans = new LinkedList<>();
        TreeNode endOflevel = root;
        int numOfLevel = 0;
        double sumOfLevel = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;

        while(!queue.isEmpty()){
            node = queue.poll();
            numOfLevel++;
            sumOfLevel += node.val;
            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right!= null){
                queue.offer(node.right);
            }

            if(node == endOflevel){
                ans.add(sumOfLevel/numOfLevel);
                numOfLevel = 0;
                sumOfLevel = 0;
                endOflevel = queue.peekLast();
            }

        }

        return ans;
    }


}
