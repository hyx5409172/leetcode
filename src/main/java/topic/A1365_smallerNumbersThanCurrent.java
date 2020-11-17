package topic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A1365_smallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] sorted = Arrays.copyOf(nums, length);
        Arrays.sort(sorted);

        Map<Integer, Integer> index = new HashMap<>(length);
        int[] ans = new int[length];

        for (int i = 0; i < length; i++) {
            if(i > 0 && sorted[i-1] == sorted[i]){
                continue;
            }
            index.put(sorted[i], i);
        }

        for (int i = 0; i < length; i++) {
            ans[i] = index.get(nums[i]);
        }

        return ans;
    }


}
