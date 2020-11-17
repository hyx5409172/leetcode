package topic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {

    public static void main(String[] args) {
        int n = 4;
        int k = 4;
        LinkedList<Integer> curList= new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        process(n, k, curList, ans);
        System.out.println(curList);
        ans.forEach(System.out::println);

    }

    public static void process(int n, int k, LinkedList<Integer> curList, List<List<Integer>> ans){
        if(curList.size() == k){
            ans.add(new ArrayList<>(curList));
            return;
        }

        int start = curList.isEmpty()? 0: curList.peek();
        for (int i = start + 1; i <= n; i++) {
            curList.push(i);
            process(n, k, curList, ans);
            curList.pop();
        }
    }

//    public static List<List<Integer>> nativeWay(int n, int k){
//        List<List<Integer>> ans = new ArrayList<>();
//
//
//        while(k > 0){
//
//
//
//
//        }
//
//
//
//
//        return ans;
//    }


}
