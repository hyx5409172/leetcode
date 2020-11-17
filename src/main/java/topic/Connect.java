package topic;

import common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 117
 * */
public class Connect {


    public static void nativeWay(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node node = null, endOfLvlNode = root, endOfNextLvlNode = null;

        // 4ms
//        while (!queue.isEmpty()){
//            node = queue.poll();
//            if(node.left != null){
//                queue.offer(node.left);
//                endOfNextLvlNode = node.left;
//            }
//            if(node.right != null){
//                queue.offer(node.right);
//                endOfNextLvlNode = node.right;
//            }
//
//            if(endOfLvlNode == node){
//                endOfLvlNode = endOfNextLvlNode;
//            } else if(!queue.isEmpty()){
//                node.next = queue.peek();
//            }
//        }

        // 2ms
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }

                if(i != size-1){
                    node.next = queue.peek();
                }
            }
        }

    }


    //基于next指针本身
    public static void linkedWay(Node root){
        Node node = null, start = root, preNode = null;

        while(start != null){
            node = start;
            start = null;
            preNode = null;
            while(node != null){
                if(node.left != null){
                    if(preNode != null){
                        preNode.next = node.left;
                    }
                    preNode = node.left;
                    if(start == null){
                        start = node.left;
                    }
                }

                if(node.right != null){
                    if(preNode != null){
                        preNode.next = node.right;
                    }
                    preNode = node.right;
                    if(start == null){
                        start = node.right;
                    }
                }

                node = node.next;
            }
        }

        return;
    }

}
