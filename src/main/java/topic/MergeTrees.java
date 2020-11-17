package topic;

import common.TreeNode;

/**
 * leetcode 617
 * */
public class MergeTrees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }

        process(t1, t2);

        return t1;
    }


    public static void process(TreeNode origin, TreeNode extra){
        if(origin == null || extra == null){
            return;
        }

        if(origin.left == null){
            origin.left = extra.left;
        } else {
            process(origin.left, extra.left);
        }

        origin.val += extra.val;

        if(origin.right == null){
            origin.right = extra.right;
        } else {
            process(origin.right, extra.right);
        }

    }




}
