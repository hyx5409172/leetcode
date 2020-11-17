package topic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A1207_uniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> frequency = new HashSet<>();

        int curNum = arr[0];
        int curFrequency = 0;
        for (int i = 0,length = arr.length; i < length; i++) {
            if(arr[i] != curNum){
                curNum = arr[i];
                if(frequency.contains(curFrequency)){
                    return false;
                }
                frequency.add(curFrequency);
                curFrequency = 0;
            }

            curFrequency ++;
        }

        if(frequency.contains(curFrequency)){
            return false;
        }

        return true;
    }

}
