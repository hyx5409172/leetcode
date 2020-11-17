package topic;

import common.TreeNode;

/**
 * leetcode 701
 * */
public class insertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curNode = root;
        TreeNode newNode = new TreeNode(val);
        if(root == null){
            return  newNode;
        }

        while(true){
            if(val > curNode.val){
                if(curNode.right != null){
                    curNode = curNode.right;
                    continue;
                } else {
                    curNode.right = newNode;
                    break;
                }
            }

            if(val < curNode.val){
                if(curNode.left != null){
                    curNode = curNode.left;
                    continue;
                } else {
                    curNode.left = newNode;
                    break;
                }
            }
        }

        return root;
    }







}
