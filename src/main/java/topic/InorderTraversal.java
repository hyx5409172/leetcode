package topic;

import common.TreeNode;

import java.util.List;

public class InorderTraversal {

    public static void nativeWay(TreeNode node, List ans){
        if(node.left != null){
            nativeWay(node.left, ans);
        }

        // doSomething
        ans.add(node.val);

        if(node.right != null){
            nativeWay(node.right, ans);
        }

    }

}
