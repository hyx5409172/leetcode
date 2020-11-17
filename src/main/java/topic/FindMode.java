package topic;

import common.ArrayToTree;
import common.TreeNode;

import java.util.*;

/**
 * leetcode 501
 * */
public class FindMode {


    public static void main(String[] args) {

        Integer[] arr = {1,1,2};
        TreeNode root = ArrayToTree.intArrToTree(arr);

        System.out.println(Arrays.toString(sortWay(root)));


    }

    public static int[] nativeWay(TreeNode root){
        Map<Integer, Integer> index = new HashMap<>();
        process(root, index);

        List<Integer> ans = new ArrayList<>();
        int[] max = new int[1];
        index.forEach((k,v) -> {
            if(v > max[0]){
                max[0] = v;
            }
        });

        index.forEach((k,v) -> {
            if(v == max[0]){
                ans.add(k);
            }
        });

        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }


    public static void process(TreeNode node, Map<Integer, Integer> index){
        if(node == null){
            return;
        }

        index.putIfAbsent(node.val, 0);
        index.computeIfPresent(node.val, (k,v) -> v+1);

        process(node.left, index);
        process(node.right, index);

    }

    //--------------------------------------------------------------------------------

    public static int[] sortWay(TreeNode root){
        List<Integer> list = new ArrayList<>();
        process2(root, list);

        int maxTime=-1,maxNum=-1,curNum=-1,curTime=-1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0,cutTemp; i < list.size(); i++) {
            cutTemp = list.get(i);
            if(cutTemp == curNum){
                curTime ++;
            } else {
                curTime = 1;
                curNum = cutTemp;
            }

            if(curTime > maxTime){
                maxTime = curTime;
                if(cutTemp != maxNum){
                    maxNum = cutTemp;
                    ans.clear();
                    ans.add(cutTemp);
                }
            } else if(curTime == maxTime){
                ans.add(cutTemp);
            }

        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    public static void process2(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        process2(node.left, list);
        list.add(node.val);
        process2(node.right, list);
    }



}
