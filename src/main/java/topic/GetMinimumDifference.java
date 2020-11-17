package topic;

import common.ArrayToTree;
import common.TreeNode;

/**
 * leetcode 530
 * */
public class GetMinimumDifference {

    public static void main(String[] args) {
        GetMinimumDifference g = new GetMinimumDifference();
        Integer[] arr = {1, null, 5, 3};
        TreeNode root = ArrayToTree.intArrToTree(arr);

        System.out.println(g.getMinimumDifference(root));
    }


    int preVal = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root != null){
            getMinimumDifference(root.left);

            min = Math.min(min, Math.abs(root.val - preVal));
            preVal = root.val;

            getMinimumDifference(root.right);
        }

        return min;
    }



}
