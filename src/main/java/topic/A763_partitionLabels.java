package topic;

import java.util.ArrayList;
import java.util.List;

public class A763_partitionLabels {

    // 官方用的for也可以
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] lastIndex = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
           lastIndex[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        while (start < length){
            int cur = start;
            int end = lastIndex[S.charAt(start) - 'a'];

            while(cur < end){
                int lastIndexTemp = lastIndex[S.charAt(cur) - 'a'];
                if(lastIndexTemp > end){
                    end = lastIndexTemp;
                }
                cur ++;
            }
            ans.add(end - start + 1);
            start = end + 1;
        }

        return ans;
    }

}
