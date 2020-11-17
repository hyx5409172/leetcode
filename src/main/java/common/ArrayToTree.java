package common;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayToTree {

    public static TreeNode intArrToTree(Integer[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(arr[0]), node, left, right;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1,length = arr.length;

        while(!queue.isEmpty()){
            node = queue.poll();
            if(index < length && arr[index] != null){
                left = new TreeNode(arr[index]);
                node.left = left;
                queue.offer(left);
            }
            index++;

            if(index < length && arr[index] != null){
                right = new TreeNode(arr[index]);
                node.right = right;
                queue.offer(right);
            }
            index++;
        }

        return  root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,null,3,null,4,null,null,5};

        printTree(intArrToTree(arr));
    }

    public static void printTree(TreeNode node){
        if(node == null){
            return;
        }

        printTree(node.left);
        System.out.println(node.val);
        printTree(node.right);

    }


}
