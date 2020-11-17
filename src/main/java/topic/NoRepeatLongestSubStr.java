package topic;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatLongestSubStr {


    /**
     * 最优解：滑动窗口
     * */
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max=0;
        int sLength = 0;
        Set dict = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if(dict.contains(chars[j])){
                    break;
                }
                sLength ++;
                dict.add(chars[j]);
            }
            max = Math.max(max, sLength);
            if(max > chars.length-i){
                break;
            }
            dict.clear();
            sLength = 0;
        }

        return Math.max(max, sLength);
    }



}
