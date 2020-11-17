package topic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 771
 * */
public class NumJewelsInStones {

    public static void main(String[] args) {
        String J = "bcd";
        String S = "cba";
        NumJewelsInStones n = new NumJewelsInStones();

        System.out.println(n.pointerWay(J, S));
    }

    // 2ms
    public int hashWay(String J, String S){
        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();

        Map<Character, Object> JMap = new HashMap<>();
        for (int i = 0, length = js.length; i < length; i++) {
            JMap.put(js[i], null);
        }

        int ans = 0;
        for (int i = 0, length = ss.length; i < length; i++) {
            if(JMap.containsKey(ss[i])){
                ans ++;
            }
        }

        return ans;
    }

    // 1ms
    public int pointerWay(String J, String S){
        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();
        Arrays.sort(js);
        Arrays.sort(ss);

        int i = 0, k = 0, ans = 0;
        int jLength = js.length, sLength = ss.length;
        while(i < jLength && k < sLength){
            if(js[i] == ss[k]){
                ans ++;
                k++;
            } else if(js[i] > ss[k]){
                k++;
            } else {
                i++;
            }
        }


        return ans;
    }





}
