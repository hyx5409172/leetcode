package topic;

import common.TreeNode;

import java.util.*;

/**
 * leetcode 106
 * */
public class BuildTree {


    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0,length = inorder.length; i < length; i++) {
            cache.put(inorder[i], i);
        }
        buildTree2(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, cache);

    }


    public static TreeNode buildTree(int[] inorder, int[] postorder){
        int rootVal = postorder[postorder.length - 1];
        int rootIndex = -1;
        for (int i = 0,length = inorder.length; i < length; i++) {
            if(inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        if(rootIndex > 0){
            TreeNode left = buildTree(Arrays.copyOfRange(inorder,0, rootIndex),
                    Arrays.copyOfRange(postorder, 0, rootIndex));
            root.left = left;
        }

        if(rootIndex + 1 < inorder.length){
            TreeNode right = buildTree(Arrays.copyOfRange(inorder,rootIndex + 1, inorder.length),
                    Arrays.copyOfRange(postorder, rootIndex, inorder.length - 1));
            root.right = right;
        }


        return root;
    }


    public static TreeNode buildTree2(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR, Map<Integer, Integer> index){
        int rootVal = postorder[postR];
        int rootIndex = -1;
        if(index.containsKey(rootVal)){
            rootIndex = index.get(rootVal);
        } else {
            for (int i = inL; i <= inR; i++) {
                index.putIfAbsent(inorder[i], i);
                if(inorder[i] == rootVal){
                    rootIndex = i;
                    break;
                }
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftLength = rootIndex - inL;
        if(leftLength > 0){
            TreeNode left = buildTree2(inorder, postorder, inL, rootIndex-1, postL, postL + leftLength - 1, index);
            root.left = left;
        }

        int rightLength = inR - rootIndex;
        if(rightLength > 0){
            TreeNode right = buildTree2(inorder, postorder, rootIndex + 1, inR, postR - rightLength, postR - 1, index);
            root.right = right;
        }

        return root;
    }





//    public static List<Integer> findHeadIndex(int[] inorder, int[] postorder){
//        List<Integer> res = new ArrayList<>();
//        int inL, inR, postL, length = inorder.length;
//        inL = inR = postL  = 0;
//        while (inL < length && postL < length){
//
//            if(inorder[inL] == postorder[postL]){
//                inL++;
//                postL++;
//                continue;
//            }
//
//            inR = inL;
//            while (inR < length){
//                if(inorder[inR] == postorder[postL]){
//                    break;
//                }
//                inR++;
//            }
//
//            while (inL < inR){
//                res.add(inorder[inL++]);
//            }
//
//            inL++;
//            postL ++;
//        }
//
//        return res;
//    }

}
