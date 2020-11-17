package topic;

import common.ArrayToTree;
import common.TreeNode;
import sun.reflect.generics.tree.Tree;

public class A129_sumNumbers {


    // 自上二下还是自下而上是两种不同的思路，应该全面考虑
    public static void main(String[] args) {
        A129_sumNumbers a = new A129_sumNumbers();
        Integer[] arr = {4,9,0,null,1};
        TreeNode root = ArrayToTree.intArrToTree(arr);

        System.out.println(a.sumNumbers(root));
    }

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }

        process(root, new StringBuilder());

        return sum;
    }

    public void process(TreeNode node , StringBuilder path){
        if(node == null){
            return;
        }

        path.append(node.val);

        if(node.left == null && node.right == null){
            sum += Integer.parseInt(path.toString());
            path.deleteCharAt(path.length() - 1);
            return;
        }

        process(node.left, path);
        process(node.right, path);

        path.deleteCharAt(path.length() - 1);
    }


}
