package topic;

import common.ArrayToTree;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 235
 * */
public class LowestCommonAncestor {

    Map<TreeNode, Integer> lvlMap = new HashMap<>();
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public void main(String[] args) {
        Integer[] arr = {};
        TreeNode root = ArrayToTree.intArrToTree(arr);
        TreeNode p = null, q = null;
        process(root, 0);

        TreeNode node1 = null,node2 = null;
        int cha = lvlMap.get(p) - lvlMap.get(q);
        if(cha > 0){
            node1 = p;
            node2 = q;
        } else {
            node1 = q;
            node2 = p;
        }

        cha = Math.abs(cha);

        while(cha > 0){
            node1 = parentMap.get(node1);
            cha--;
        }

        while(node1 != node2){
            node1 = parentMap.get(node1);
            node2 = parentMap.get(node2);
        }

//        return node1;
    }

    public void process(TreeNode node, int curLvl){
        if(node == null){
            return;
        }

        lvlMap.put(node, curLvl);
        if(node.left != null){
            parentMap.put(node.left, node);
            process(node.left, curLvl + 1);
        }

        if(node.right != null){
            parentMap.put(node.right, node);
            process(node.right, curLvl + 1);
        }

    }

}
