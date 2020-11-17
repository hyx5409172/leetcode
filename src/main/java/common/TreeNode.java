package common;

import java.util.function.Consumer;

public class TreeNode {
    enum Order {vlr, ldr, lrd}

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 前序遍历
    public void vlr(Consumer<TreeNode> action){
        process(this, Order.vlr, action);
    }

    // 中序遍历
    public void ldr(Consumer<TreeNode> action){
        process(this, Order.ldr, action);
    }

    // 后序遍历
    public void lrd(Consumer<TreeNode> action){
        process(this, Order.lrd, action);
    }

    private void process(TreeNode node, Order order, Consumer<TreeNode> action){
        if(node == null){
            return;
        }

        if(order == Order.vlr){
            action.accept(node);
        }
        process(node.left, order, action);
        if(order == Order.ldr){
            action.accept(node);
        }
        process(node.right, order, action);
        if(order == Order.lrd){
            action.accept(node);
        }
    }

    @Override
    public String toString() {
        return "{\"TreeNode\":{"
                + "\"val\":"
                + val
                + "}}";

    }

    //    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public TreeNode getLeft() {
//        return left;
//    }
//
//    public void setLeft(TreeNode left) {
//        this.left = left;
//    }
//
//    public TreeNode getRight() {
//        return right;
//    }
//
//    public void setRight(TreeNode right) {
//        this.right = right;
//    }
}
