package topic;

import common.ArrayToTree;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * leetcode 968
 *
 * 根据当前节点的状态决定子节点的尝试行为是自上而下的尝试。
// * 自上往下的尝试 子树之间难以交互，
 * 根据子节点的状态决定当前节点的行为，更倾向贪心？
 * */
public class MinCameraCover {

    static Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Integer[] arr = {0,0,0,0,0,0,0,0,0,0,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,0,0,0,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,null,0,0,0,0,0,0,0,0,null,null,0,null,0,0,0,0,0,0,0,0,0,0,0,0,null,null,0,null,0,0,null,0,null,0,0,0,0,0,null,null,null,null,0,0,0,0,null,null,0,0,0,0,0,0,null,null,null,null,0,null,null,0,null,null,null,null,0,0,0,0,0,null,0,0,null,null,0,0,0,0,0,null,0,null,0,0,0,0,0,0,null,null,0,0,0,0,0,null,null,0,0,null,0,null,0,null,0,0,0,null,0,0,null,0,0,null,0,0,0,0,0,0,0,0,0,0,null,0,0,0,null,0,0,0,0,0,null,0,0,0,null,null,0,0,0,0,0,0,null,0,0,null,null,0,null,0,0,null,0,0,null,0,0,0,0,0,null,0,null,0,null,null,null,0,0,0,0,0,0,null,null,null,0,0,0,0,0,null,null,null,0,null,null,0,null,null,null,null,0,null,0,null,0,0,0,null,null,0,null,null,null,0,0,0,null,null,0,0,0,0,null,null,0,0,null,0,0,0,null,0,0,null,0,null,0,0,0,0,null,0,0,0,0,0,0,0,null,0,null,null,null,0,0,0,0,0,null,0,0,0,0,0,0,0,0,0,null,null,null,null,0,null,null,null,null,0,0,null,null,0,null,0,0,0,0,0,null,0,0,0,0,null,0,null,null,null,null,null,null,null,0,0,0,0,null,0,0,null,0,0,0,0,0,0,0,null,0,null,null,0,null,null,null,null,null,null,0,0,null,null,0,null,null,null,null,null,0,null,0,0,0,null,0,0,0,0,0,0,0,0,null,0,0,0,0,0,null,null,null,0,0,null,0,0,null,0,null,null,0,0,null,null,null,0,0,null,null,null,null,0,0,0,0,0,null,0,0,null,0,0,0,null,0,0,0,0,null,0,null,0,0,0,0,0,null,null,null,0,0,0,0,0,0,0,null,null,null,null,0,null,0,null,null,null,0,0,0,null,0,null,null,null,0,null,0,0,null,null,null,0,null,null,0,null,null,0,0,0,null,0,null,null,null,null,0,0,0,0,0,0,0,0,0,0,null,0,0,0,0,null,0,null,null,0,null,null,0,0,null,null,0,0,null,0,0,0,0,0,0,0,0,0,0,0,null,0,0,0,0,0,0,0,0,null,0,0,0,0,0,0,0,null,null,0,null,null,0,null,0,null,0,null,0,0,0,0,0,null,null,null,null,null,null,0,0,null,0,0,null,0,0,0,0,null,null,null,null,null,0,null,null,0,null,0,null,null,null,0,null,null,null,null,0,0,0,0,null,null,0,null,null,null,0,0,0,null,0,0,0,0,0,0,null,0,null,null,0,0,null,null,null,null,0,null,null,null,null,null,null,null,null,0,null,null,null,null,0,null,0,null,0,null,0,0,null,0,null,null,0,null,0,null,0,null,null,0,0,null,0,null,0,0,0,0,0,0,null,0,0,0,0,null,null,null,null,null,0,0,0,0,0,0,null,0,0,0,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,0,0,0,0,0,null,0,null,0,0,0,0,0,0,null,0,0,0,null,null,null,null,null,null,null,null,0,null,0,null,0,null,null,null,0,null,null,null,0,0,null,null,null,0,0,0,0,0,0,null,null,null,null,null,0,0,null,0,0,null,null,null,null,null,null,0,null,0,null,null,null,0,0,0,null,0,0,null,0,0,null,null,null,null,null,null,0,0,0,0,0,null,null,0,null,null,0,0,0,0,0,0,0,null,null,null,0,0,null,null,null,null,null,null,null,null,null,null,0,null,null,null,null,0,null,null,null,null,null,null,null,0,null,null,0,null,0,0,null,null,0,null,null,null,0,null,null,null,null,null,null,null,null,null,null,null,null,0,null,null,null,null,0,0,null,0,0,0,null,null,null,null,0,0,null,null,null,null,0,0,0,0,null,null,0,0,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,null,null,null,null,0,0,null,null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,0,null,null,0,null,null,null,null,null,0,null,null,null,null,null,null,0,0,null,0,null,0,0,0,0,null,null,null,null,null,null,0,0,0,0,0,0,0,0,0,null,null,null,null,0,0,null,null,null,null,0,0,null,null,0,null,0,null,0,null,null,0,null,null,null,null,0,null,0,null,null,null,null,0,0,null,0,0,0,null,0,0,0,null,0,null,null,null,null,0,null,null,null,null,null,null,null,null,0,0,0,0,null,0,null,0,null,0,null,0,0,0,0,0,null,0,0,0,null,null,null,null,0,0,0,0,null,0,0,null,null,0,null,null,0,null,0,0,null,0,0,0,null,0,0,null,null,null,0,0,null,null,null,null,null,0,0,0,null,0,0,0,0,0,0,0,0,null,null,0,0,null,0,null,null,null,0,0,null,null,null,0,0,null,0,null,null,0,null,null,0,0,null,null,null,0,0,null,null,0,null,0,null,0,0,null,null,null,0,0,null,null,null,null,0,0,null,0,null,null,null,null,0,0,0,0,0,0,null,null,null,0,0,null,0,null,null,null,null,0,null,0,null,null,0,0,null,null,0,0,0,0,null,0,null,null,null,null,null,null,null,null,null,0,0,0,null,0,null,null,0,0,null,0,0,0,null,0,null,null,null,0,null,0,null,null,0,null,0,0,0,0,0,0,0,0,0,null,null,0,0,0,null,null,null,null,null,0,0,null,null,null,null,0,0,0,0,0,null,0,0,0,null,null,null,null,null,0,null,null,0,0,0,0,0,null,null,0,0,0,0,null,null,null,0,0,null,null,0,null,null,0,0,0,null,0,null,0,null,0,null,null,0,0,null,null,null,null,null,null,null,null,null,null,null,null,0,null,null,0,0,null,null,null,null,null,0,null,0,0,0,0,null,0,0,0,null,null,0,null,null,0,null,null,0,null,null,null,null,null,null,0,0,0,0,0,0,0,null,null,null,null,null,null,0,0,null,0,null,0,null,null,null,null,null,0,null,null,null,null,null,0,0,0,0,null,null,null,null,null,null,null,null,0,0,0,0,0,null,0,0,null,0,0,0,0,0,0,0,null,0,0,0,null,null,0,null,null,null,null,null,null,null,null,0,null,null,null,0,null,0,null,0,0,null,null,0,0,null,0,0,0,null,0,0,0,null,0,null,null,null,null,0,null,0,null,0,null,null,null,null,null,null,0,0,0,null,null,0,null,null,null,0,0,null,null,null,null,0,null,0,null,null,null,0,null,0,0,0,0,0,0,null,0,0,null,null,null,0,null,0,null,null,0,null,null,null,null,null,null,null,null,null,null,0,null,0,0,null,null,null,null,0,null,0,null,null,null,null,0,0,null,null,0,null,null,0,0,0,0,null,0,null,null,0,null,null,null,0,null,0,0,0,null,0,0,0,0,0,null,null,null,null,null,0,null,0,null,0,null,null,0,null,null,null,null,null,null,null,null,null,0,null,0,0,0,null,null,null,null,0,null,null,null,0,null,null,null,null,0,null,null,null,null,null,null,null,null,0,null,0,null,null,null,0,null,null,null,null,null,0,null,0,0,0,0,null,null,null,0,0,0,null,0,0,0,null,0,null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,null,null,null,null,null,null,null,0,0,0,0,0,0,null,null,null,0,0,null,null,null,0,0,null,0,0,0,0,null,null,null,0,null,null,null,null,null,null,null,null,null,0,null,null,null,null,null,null,null,0,0,0,0,0,null,0,0,null,null,null,0,0,0,0,0,null,null,null,null,null,0,0,0,null,0,null,null,null,null,0,0,0,null,null,null,0,null,null,0,0,null,null,0,0,null,null,null,null,null,null,null,0,null,0,null,null,null,null,0,0,null,null,0,0,0,0,0,null,null,0,null,null,0,0,0,0,0,0,null,null,null,0,null,null,null,0,0,null,null,null,null,null,null,null,null,null,null,0,0,null,0,null,null,0,null,0,null,null,null,null,null,null,null,0,null,null,null,null,null,null,null,0,null,0,null,null,0,null,null,0,0,null,null,null,0,null,null,0,0,null,null,0,0,0,0,0,0,0,0,null,null,0,0,null,null,null,null,null,null,null,null,0,0,0,null,null,null,null,0,null,0,null,0,null,null,null,null,0,0,null,null,null,null,null,0,0,0,null,0,null,null,null,0,null,null,0,0,null,null,null,null,0,null,null,null,null,null,0,0,null,null,null,null,null,null,0,0,null,null,null,0,null,null,null,null,null,null,null,null,null,null,0,null,null,null,null,null,0,0,null,null,null,null,null,null,0,0,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,0};
        TreeNode root = ArrayToTree.intArrToTree(arr);

        int num = process(root, false);
        System.out.println(num);
    }

    /**
     *  状态没选对
     * */
    public static int process(TreeNode node, boolean parentNotLight){
        if(node == null){
            return 0;
        }

        boolean nodeLight = node.val > 0;
        String cacheKey = node + Boolean.toString(nodeLight) + Boolean.toString(parentNotLight);
        if(cache.containsKey(cacheKey)){
            return cache.get(cacheKey);
        }

        // 自身安装
        lightNode(node);
        int self = process(node.left, false) + process(node.right, false) + 1;
        nodelightsOut(node);

        int son = Integer.MAX_VALUE;
        // 父节点亮了并且 （自身亮了或者有子节点）
        // 自身不安装
        if(!parentNotLight && (node.left != null || node.right != null || nodeLight)){

            if(nodeLight){
                son = process(node.left, false) + process(node.right, false);
            } else {
                if(node.left == null || node.right == null){
                    son = process(node.left, node.right == null) + process(node.right, node.left == null);
                } else {
                    son = process(node.left, true) + process(node.right, false);
                    son = Math.min(son, process(node.left, false) + process(node.right, true));
                }
            }
        }

        int min = Math.min(self, son);
        cache.put(cacheKey, min);
        return min;
    }

    public static void lightNode(TreeNode node){
        if(node != null){
            node.val ++;
            if(node.left != null){
                node.left.val ++;
            }

            if(node.right != null){
                node.right.val ++;
            }
        }
    }

    public static void nodelightsOut(TreeNode node){
        if(node != null){
            node.val --;
            if(node.left != null){
                node.left.val --;
            }

            if(node.right != null){
                node.right.val --;
            }
        }
    }

}
