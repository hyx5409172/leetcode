package topic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class A1122_relativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            index.put(arr2[i], i);
        }

        Integer[] ans = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            ans[i] = arr1[i];
        }

        Arrays.sort(ans, Comparator.comparing((Integer n) -> index.getOrDefault(n, Integer.MAX_VALUE))
                .thenComparing((Integer n) -> n));

        int[] res = new int[ans.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans[i];
        }

        return res;
    }


    class Adder {
        int val;

        public Adder(int val) {
            this.val = val;
        }

        public void add(int n1){
            val += n1;
        }

        public int get(){
            return val;
        }
    }
    // 计数
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        int max = 0;
        for (int i = 0; i < arr1.length; i++) {
            counts[arr1[i]] ++;
            max = Math.max(max, arr1[i]);
        }

        int[] ans = new int[arr1.length];
        Adder index = new Adder(0);
        Consumer<Integer> addAns = val -> {
            while(counts[val] > 0){
                counts[val] --;
                ans[index.get()] = val;
                index.add(1);
            }
        };

        for (int i = 0; i < arr2.length; i++) {
            addAns.accept(arr2[i]);
        }

        for (int i = 0; i <= max; i++) {
            addAns.accept(i);
        }

        return ans;
    }


}
