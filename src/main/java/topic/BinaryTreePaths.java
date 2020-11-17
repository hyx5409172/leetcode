package topic;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths {


    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();


        System.out.println(ans);
    }


    public static void process(TreeNode node, List<TreeNode> path, List<String> ans){
        if(node.left == null && node.right == null){
            List<String> oneAns = new ArrayList<>(path.size());
            path.forEach(e -> oneAns.add(String.valueOf(e.val)));
            ans.add(oneAns.stream().collect(Collectors.joining("->")));
            return;
        }

        if(node.left != null){
            path.add(node.left);
            process(node.left, path, ans);
            path.remove(node.left);
        }

        if(node.right != null){
            path.add(node.right);
            process(node.right, path, ans);
            path.remove(node.right);
        }

    }



}
