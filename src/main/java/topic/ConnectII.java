package topic;

import common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 116
 * */
public class ConnectII {

    public Node connect(Node root) {
        // nonNull
        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node cur = null;
            Node pre = null;
            for (int i = 0, length = queue.size(); i < length; i++) {
                cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }

                if(pre != null){
                    pre.next = cur;
                }
                pre = cur;
            }
        }

        return root;
    }
}
