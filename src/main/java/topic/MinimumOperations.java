package topic;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode LCP 19
 * */
public class MinimumOperations {

    char RED = 'r';
    char YELLOW = 'y';
    Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        String leaves = "yyyrrrrrrrryyrrryryyyryyyyryrrryyrrryrryyryryryyrrryyyyyyrrrrryrryryyrrrryyyryrrrryyrryrrrryryryrrryyyyyyrrrryryrrrryrryyrrryryyyyryyyyyryrryryrryyryyryryrrrryryrryyyryrrryrrryryyyyyrryyrryrrrryrrrrryrryyyyyrrryryyyryryrrrryrryrryryyyryryryyyrrryryrrryrrrryrryrryryyrrrrryyrrryrrrryyryryryrrryyyyrryrryyrrrrrrryyryyrryryrryyrryrrrrryyyyyrrryyrryrrryrrrrrryyryyyrrrrrryryrrryyrryyyrrryrrrryyyyryryyyryrryyyyyrrryyyyrrryryyyryyryrryyyyyyyyrryyyyryryyyrrryyryyyyyyrryryrryyryryrrrryryrrrryryyryryryryryryyryyrryyyryrryyryyrryyyrrrryyyyrryrryyrryyyryyyryyrryyyyryyryyrryrryyrryryyyyrrryyyyyyryyyyryryrryyyyryrrrrryrrryrryrryyyyryyryyrrryyyryrrryryyrryyyrryryrryyyryyyyryyyryyryrrryryryryrryryyyyryyryyryyryryrrrrrrryyryryyrryyrryryrryyryyrryyyryyyrrrrryryrryyryyrryyyrryyryryrryrrryyyyyrryyrrrryyyyyyyryyyyrrrryrryyryyryrryyyyryyrrrryrrryyrryrrryryrryyrrryyrryyyryyyyyyryyrrrryryyyyryyrryrrryyrryryryryryrryrrryyyryyyyryryyrryryryrryyryrrrryyyryryyyrryyrryyyyyyyryrryryyyryyyrrrrryyyyryrrryrryryryyrryrrryrryrryryrrrrrryyrryyryryryyryyyrryryryyyyryyryryyyyrrryyyrrryrryyyyyrrrryyyrryrrrrryyryyrryryrryryryrryyyrrrrrryyyyrrrryyryyryrrryyryyryrryryyyyrrryyryryryyryyyyryryyyryrryryyrrryyryryryrrrryyryrrryyyyrrrrrrrryryyyyyryyryyyrrryyrrrrryyrrryryyrryrryryyrryrryryryrryyryryrrryrryrrrrrrryyryyrrryyrryyyrrryyyyyryyyrrrrrrryrrrryyyyryyrrrryryrryyrryryrrryrryyrryyyrrrryyyyrryryryrrrryyrryryrrryyrrrryrrrryyryyyyyrrryyyryryryrrrrrrryryyryyrryryyrryyrrrrrrryrrrryyrryrrrrrrrryrrrryryryryryyyyyyryyyyyrrrryyyyyyyrryyyyrrryrryryyyryrrrryryrrryyrrryryrrryryyyyyrryrryyryryyyyyrrryrryrryryyryyyryyryyryryyyyyryyryyryrrrryyryyrrryryrrrryrrrrrryyryyrryrryryryyryrrryyyyyrrryyrryyyryrryyyryyyryryryryyyrrryryrrryyrrrrrryyyrryrryrryyrryrryryyryrrrryryyryrrrryyryyyryrrryrrrrrrrrrryrryyyyryyyrrryrrrrryrryrrryyyyryyrrrrryyrrrryyyyyyrrryyrryyryyyrryyyrryyyyrrryyyyyrryryyryyyyryryyyyyrrryryryyrrrryyyryrrrrryyrryyryryyyyyrryrrrryyyryyyryrrryrryryyryyyryyyrrrrrrryryrryyyyryyyyyyryyrryyyyyyyryrryyrryyrryrrrryryyrrryyyryryrrrrryrryryrrryyyyyyryryryyyryrrryryryyryrryyyryrryyyyrrryyryyyyyryyyrryryyyryyryrryrryrrrrryryyyrrryyyyryyyyyyrryyrryyyryyyyrryrryryryyryryrrryrrrryyyyrrryyyyyryyyryrrrryyyyrryyryryrryyyrryyyryyrrryyryyryryrrrryryyrrrrrrrrryrryryrryyrrrryyryrrrryyyrrrryyyyyrrryyyyrrryyryrryrrrryyyryrryyyyyrryryryyyyryryrryyyrryyryyyyryyryrryryryyyyyyyryryrrrryryyrryyyrrryyryrrryryyrryryyyyyyrryyryrryyyyyyrryrrryyyyrrryryryyyyyyrrryyrrrryryyyyyyyyrryyyyyryyyyryryyrrryrrryryryrrryryyrryyyyryryyryryyyyyyyyryrrryrrrrrryyryrryyyyryyyryyyyrrrryrrryyryryrryyryyrryyyryyryyyryyyrrryyyyrryryyrrrrryrrrryyyryyrrryyyyryyryryyryrrryrryryrrrryyrryryrrryyrrrrrryyrrryryrrryrryryryyyrrrrrrrrryyrrrryyryryrryyryyyrryryyyrrrrrrrrryyrryrrrrrrrrryryrrrryyryyryyyyrrryryyryyyyyyyryyyyyyrrryrryryyyrryyryryrrrrryrryrryrryyyyrryryyyrryrrrrrryryyryyyyrryrryrrryyyrryyyyryrryryryrrrryyrrryyyyryyyyryryyyrryrryyyyryyyryyyyryryrrrrrrrrryryyryrrryyyyyyyrryyrryyyyyrryrrrrrryyyyrrrryyryyyrrryryyrryryryryryyyrryrryyryrrryyryrrryyryyyrrryrrrrryryyyyryryrryryyrryyyryrrryrryyryryyrrrryyyryryryyyyrryyyyyrryrrryyyrrryrrryyyrryyyyrryyyryyyrrryrryyrrrryyrrryyryryyyrryrrrryyyyyyyryyrryrrryyryyyyyrrryrrrryryyryyyyryyyryrryyryryyrryyrrryrryyyrryyrryrryyrrrryyrryryyyrryryrryyyyyyyyyryryryyrryrryrrrryyyrrrryyrryryrrrrryryyyyyyrryyyyrrryryyryyryryyyyryyrryyyrryyyyrryryyyyyryyryryryrrryryyryyryyyryrrrrrrryrryyrrrryrryyryyrryryyryryryyyryyyyyyyrryyryyrrrryyyyyryyyrrryrrrryyyyyyyryyyryrrrrrryryryyrrryryryryrryyrryryyyyyrrryrryyyryyyyrryyrrrrryryyrrrrrryryyrrrryryyryrryyyyyyryyrrryryryyrrryyrryyyyyryyyyyrrryyyyrrrryyyrryyyyyrryrryryyrrryryyyyryyrrrryrrryyrryyrryyryyryrrryryyrryyyyrryrrrrrryrrryryyyrrryyrrryrryrryyyyryrryryrryrryrryrryyrryyryryyyyyyyrrrryyyrryyyryyyrryyyyrryyryryrryyryyrrrrrryyyryyryyyrrryryyyyryyyrrryryyyryyrrryrryryyyyrryyyrryryryyrryyyyyrrryryyrrryryyrryyyyrryyyrryyyrryyryyryyrryrrrryrryrryryyryrryyyrryyryyrrrryyryyyryyyyrryyryyrryyyryrrryyryrryyryrryyrrrrrrrrrrryryyyyrrrryyyyryyyrryryrrrryrrrryyyrrrryyyyryrrrrrrrrryrryrryrrrryryyyyyyrryyyrryyryryyryrryrryryrryyyrryrryrryryrrrrrryryyyryyyrrrryrrrrryrrryryryyryyryyyyryyyyrryyyyyryyyrryryyryryyryyryryrryryryyryyyryyryyryryrrrryyyrrryrryyrryyryyyrrryryryrrrryryryryryrryyyrryyyyryryryryyyyyryryrrryyyyryyryyrryyyyyryryrrryyyyyyrrrryryyyryyryrrrryryyyyryyyyyrrryryryyrrryrryyyyyyyrryryrrrrrrrryyyyyryryryryyrryrryryyrryrrryrryyryryrrryyyyyyyyrryryyrrryrryyryryrryyyyrrrryryryyrrryyryyryyrrryyyyryrryyyryyyyrryyrrryyryrryryyrryrrrrrrryyyyryrrrryrryrryyyyyyyyrryyryyyrryyryrryyrryrrrryrryrryyryyyryyyyyrryryyryrrryyryyyyyryrrryrryryyryryyryryryryyryyyyyyyyyyrryryyrryyyryryyryryrryyyyyyyryrrryrryyyrrryrrryrryryrryyyyyyyryrryyyryyrryrryyyryyyyrryryyrrryryrryryryrryyryrryrryyrryyryyryryrryryyyyyrrryryryyrryyrrrryyyrrrrryyryrryyryryyyyrrryyrrryyryyyryrryrrrryyyryryyryryyryyrrrryyyyryryyrryryryyryyyyyyryyyyyyryryyyryryyyrrryyyyrryryryrrrrryrrryrryrrrrrryyyyyryyrryrryrrrryryryrryryyyyryryrrryrrrryrryyyrryryyyrrryryyyrryrryryryyryrryrrryyrryyyrryrryyyrryyyryrryyyrryyrryyrryyrrryryyyryrryrrrrryyyrrryyryyyyyyyrryrryryryrrrryryyrrrryrryyyrryyyryyyryyrrrrrryyryyrryrryryrryyyyryrrryryryrrryyrryyrrrryyyyryryyyyyryyyryyyryyryyrryyryryyyrryryyyyrryyyyryyyyyyyrrrrrrryrryrrryyyyyrrrrryyryyyrrrryryyrryyrryryrryyyrryrrryyyrryrryryyyyrryrrryrrrrrryyyyyryrryrryryyrrrryyyryyyyryyryyrryyyrryyyrrrryrryryrrrryyyryyrryrryryrryryrryryrrryrrryyryrrrryrrrrrryrrryyryryyryrrryryyrrrryryrryryyyyyyryrryyyyrryyyryryrrryryyryyyryrrrrrrryryyryryryryyrryyryyryrryyryyrrryyryyyrryrryyyyyryrryrrryyrrryryrrrryyyrrryyyyyryrrrrryryryyryrrryryrryyrryyrrryryrrryryrrryyyryyyyryrryyrryyryrrryyyyryrrryrryryyryryyyryryyrryrrryryyyyyyryryrryryyyyyryyryryyyyrrryryyyryyryryryyrrrryyryrryryryryrryyyrrryrrrryyryrryyrryyyyyyryyrryrrrrrrrrryyyyrrryyyryryrryrrryyyyyyyyrryyryryyyyyyrrrrryyryyryrryryyyrrryyryryryyyyrrrryyrryyyryrryyyyyyryrryyryrrrrrryryrryyyyryyyrrrryyyrrryryrrrryyrrryrryrrryrrrrrrryyryryyryyyryyryyryyyrryryrrryryryrryyyryyyrrryryrryyyyyyyyyrrrrrryryrrrrryrrrryryryyryrryyrryyrrryyyryyrrryrrryyrrryrrrrryryyyyyrryyyrryyyrryyyryryryryyryyyyrryrryrryrrrryryrryyyryryrryryrryrrrrryrryyyrryyrrrrryyyyrryyrrryrrrryyrryrryyyyryryrrryyyyrryyryryyyrrryryrrrryyryyryrrrryrrryyrryrryyyyrryrrryyryyyyrryrryryyyrryrryrrryyryryyyyryryrrrrrryrryryyrryrryryryrryrrrrryyryrryyrryyryyryyryyyrrryyryryryryrrryryyyyyryryrrrryyyyrryrryyyrryyryryrrrrryyryyyrryryyyyyyrryyyrrrryyyrryrrryryrrrrrrryryyyryrryyrryrryrrrryyryrryyrrryyyyryrryyryyyryyryryrrrrrryyryryyrrryyryyyyyryrrrrrrrrryyrryyyrryryrryrryyryryrrryryrrrryyrrryryrryrrrryryrrryyyyrrryrryrryrryyyrrryyyyryryryryrryyyyryyyrrrryryryrrryyyryyyyrrryyrryyrrrrryrryrrryryrryyryryyryyyyryryryryyyyrrrrryryyryrrryryryrryyyryrryryrrryryrryrryyyyyyyyrrryryyyrryryryyyryryyyrrrryyrryryyyyryyyrrrrrrrryyryrryyryrryyrryryyryyyrrryyyryyrryyryrrryrryrrrryrrryyrryrryyyyryyyrryyyryryryryryryryyryyryryyyyyrrrrryyyyyyyryyyrryyyyyyrryryyyyyyryrryyrrryyyyyyryryrryyyrrrryryrryyryrrrrrrryryyyyyrryyyyrryrrrrrryyyyyyyryyrryryyyyryrrrrryyryyrryrrrrrrrryryyryrryrrryrryrrrryyyrryyyrrryyrryryrrryyryyryryyryrryyryyryrryrryrrrrryrrrrryryryrrrryyyrrryyyyyrryryrryrryyrryryyrryryyyryryryryyyrrrryyyrryyryryryyryyyyrrrryrryyyrrryyyyyyryryyryyrrrryryrryyrryyryyrrryyyyyrrryyyyryyyrrrryyryyyryyrryyrryyyyyyrryyyyryryryrryrrrrrryyryryyryrryryyyrrryyyyryrrrryyryrryyrrryryryryyyrrrryrrrrryyyyyryrryyyryyrrrrryyyyyyyryryyyyyyyrrryrryryyrryyyyrrrryyyryrrrrrrrrryyryrrryyryryyyyryyryyrryyyyyyrrryyyyyrryrryryyrrrryyryyrryyryyyyyrrryryyrryrrryryryryyrryyrrryyyryyryyryryrrrryyyryryyryyyrrrrryrrryyryyyyrryyyryrryyyrryyyyyryryyryyyryyyrrryyyrrryyyryryyryryyryrrryrrrrryyryrrryrrrryyrrrryyyryyryyyryyryyyyyyyrrrrryyryyyyyyyryrrryrrrrryryrryyrrrrrrryyrryyryyyyyryyyryyrryryrryryyryryyyryryryrrrryyrryryryrryrrrryrryyyyrrrrrrrrrryyyryryyyrrryryyyyyrrrrrryryryyyyyyrrryrryyrrrrrrrryyyryrryryryrrryrryyrryyrryyyyyrryyyyryyyyryyrryrrryrryryryrrryrryyrryyryyryyrrryyyyyryyyyryrryrrrryyryyrrrryrrryryyryryryryrryyyyryyrryyrryryrrryyyrryrrrrryrryrrryyyyyrrrrryyryyrrryyyyryrryyyyyyyyryyrryryyyryrryrryrryryyryrrryryrrrrrrryryryyyyyrrrryrrryrryyryryyryryryrryyrrryrryyryryyyyyyyyrrryrrryyyyryyyyyyrrrrryyyyyyyyyryrrryryryrryrrrrryyyrrryyrryyyyyyyryyyrryryryrryryryyyrryyyyryyyyryryyyyyrrrryyrrrryyyyrrrrryyryyrryryyyyryrryyyryrryyrrrrryyrrryryyrrrrryyyyyyryrrrryrrryryyryyrryryyrryrrrrryrryyyyryyyyyrryryyyryrryyrrrrryrrryyryyyrryyyyyryyyryrrryryyryyyryryyyrrryrryrrryyyryrrryryyryryyryyryrrrrryrrrryrrrrrrryyrrryryryryyryyyryyyrrryyyrrryyyryyrryrrrryyyyrryyryyyyryyryyyyrrrryyyryrrrrryrrryrrryyyrrrryyrrrryyrryyryryyrryrryrrryrrrrryyryryyrrryrrryyrryyyyrrrrrryyrryyryryrrryrryrryryrryyryyyyyrryryyyrryryrrryyyyrryryrrryryyyryyyryyryryyrrryrryyyyrrryyrryrryrrryyyryyyrryrrrryrrrryrryrrrrrrrrrryyrrrryyyyyryryyyyyryryrryyrryyryryrrryyryrryyyyryrrrrrrryyyyyryyyryrryyyrrrrrrryyyrrryrrrrryrrryyryryryryrrryryryyyyyrryyrryryyyryyrryryyyrrrryyyyyyyyryyrrrryryyyyyyryryrrrryrryyryrryryryryyyryyrrrrryyyyrryyrrryryryrryryyyryyrryyyryyryyryryryyyyyrrrrryrrryyrrrrrrrryyryryrryyryryryyrrrrrrrrrrryyyryrryrrrryryyyryyryrryyyryrrryyryrrrrryyyryyyrryrryryyyyrrryyyrrrryyryryyyyyyyrrrryyyrrryyrryrrrryryyyyyyyryryrryryryrryyryyryryyrrrryryyryyryyyyryyryyyrrrrrrrryyrrr";
        MinimumOperations m = new MinimumOperations();
        System.out.println(m.nativeWay(leaves));
//        System.out.println(m.dpWay(leaves));

    }

    // 错误解法
//    public int smartWay(String leaves){
//        int ans = 0;
//        char[] leaveArr = leaves.toCharArray();
//        int lenght = leaveArr.length;
//        if(leaveArr[0] == YELLOW){
//            ans++;
//        }
//        if(leaveArr[lenght - 1] == YELLOW){
//            ans++;
//        }
//
//        int left = 1,right = lenght -2;
//        while(leaveArr[left] != YELLOW){
//            left ++;
//        }
//
//        while(leaveArr[right] != YELLOW){
//            right --;
//        }
//
//        // 此时无Y，任意转换一个R即可
//        if(left > right){
//            return ans + 1;
//        }
//
//        int maxYIndex = left;
//        int maxYLenght = 0;
//        for (int i = left, curYStart = left, curYLength = 0; i <= right; i++) {
//            if(leaveArr[i] == YELLOW){
//                curYLength ++;
//                if(curYLength > maxYLenght){
//                    maxYLenght =curYLength;
//                    if(maxYIndex != curYStart){
//                        maxYIndex = curYStart;
//                    }
//                }
//            } else {
//                curYLength = 0;
//                curYStart = i + 1;
//            }
//        }
//
//        // 分两段， maxY左侧和右侧  每段应该是 r---y / y---r 下面算法不对
////        int yCount = 0;
////        for (int i = left; i < maxYIndex; i++) {
////            if(leaveArr[i] == YELLOW){
////                yCount ++;
////            }
////        }
////        int rCount = maxYIndex - left - yCount;
////        ans += yCount > rCount? rCount:yCount;
////
////        yCount = 0;
////        for (int i = maxYIndex + maxYLenght; i < right; i++) {
////            if(leaveArr[i] == YELLOW){
////                yCount ++;
////            }
////        }
////        rCount = right - maxYIndex - maxYLenght - yCount;
////        ans += yCount > rCount? rCount:yCount;
//
//
//
//
//
//        return ans;
//    }

    // 398ms 递归栈溢出
    public int nativeWay(String leaves) {
        int ans = 0;
        char[] leaveArr = leaves.toCharArray();
        int lenght = leaveArr.length;
        if (leaveArr[0] == YELLOW) {
            leaveArr[0] = RED;
            ans++;
        }
        if (leaveArr[lenght - 1] == YELLOW) {
            leaveArr[lenght - 1] = RED;
            ans++;
        }

        ans += process(leaveArr, 1, 0);

        return ans;
    }

    // y->r r->y y->r

    public int process(char[] leaves, int index, int trendChange) {
        int ans = Integer.MAX_VALUE - leaves.length - 1;
        boolean changed = leaves[index] != leaves[index - 1];
        int newTrend = trendChange + (changed ? 1 : 0);
        if (index == leaves.length - 1) {
            if (newTrend == 2) {
                return 0;
            }
            return ans;
        }
        String cacheKey = index + "-" + trendChange;
        if(cache.containsKey(cacheKey)){
            return cache.get(cacheKey);
        }

        // 不变
        if (newTrend <= 2) {
            int nextIndex = index + 1;
            while (nextIndex < leaves.length - 1 && leaves[nextIndex] == leaves[index]) {
                nextIndex++;
            }
            ans = Math.min(process(leaves, nextIndex, newTrend), ans);
        }

        // 变
        leaves[index] = leaves[index] == RED ? YELLOW : RED;
        changed = leaves[index] != leaves[index - 1];
        newTrend = trendChange + (changed ? 1 : 0);
        if (newTrend <= 2) {
            ans = Math.min(1 + process(leaves, index + 1, newTrend), ans);
        }
        leaves[index] = leaves[index] == RED ? YELLOW : RED;

        cache.put(cacheKey, ans);
        return ans;
    }

    public int dpWay(String leaf){
        char[] leaves = leaf.toCharArray();
        int length = leaves.length;
        int[][] dp = new int[length][3];
        dp[length - 1][2] = leaves[length - 1] == RED ? 0 : 1;
        dp[length - 1][1] = Integer.MAX_VALUE - length;
        dp[length - 1][0] = Integer.MAX_VALUE - length;
        dp[length - 2][0] = Integer.MAX_VALUE - length;
        for (int i = length - 2; i >= 0; i--) {

            dp[i][2] = dp[i + 1][2] + (leaves[i] == RED? 0 : 1);

            dp[i][1] = Math.min(
                        dp[i + 1][1],
                        dp[i + 1][1 + 1]) + (leaves[i] == YELLOW? 0 : 1);
            dp[i][0] = Math.min(
                        dp[i + 1][0],
                        dp[i + 1][0 + 1]) + (leaves[i] == RED? 0 : 1);
        }

        return dp[0][0];
    }



}
