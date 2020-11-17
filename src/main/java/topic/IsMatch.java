package topic;

import java.util.HashMap;
import java.util.Map;

public class IsMatch {

    public static final char EMPTY_CHAR= ' ';
    public static final char OMNIPOTENT_CHAR= '.';
    public static final String SEPARATOR= "_";
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
//        System.out.println(p);
//        System.out.println(dealPattern(p));
        Map cache = new HashMap();
        System.out.println(process(s, 0, p, 0, cache));
        System.out.println(dpWay(s, p));
    }

    /**
     * 直接处理的方法
     * 搞不定.*的处理
     * */
    /**
    public static boolean match(String s, String p){
        if(s != p && (s == null || p == null)){
            return false;
        }
        if(s == p){
            return true;
        }

        // aaaabab
        //  a*abab
        int sIndex = 0,pIndex = 0;
        while(pIndex < p.length()){
            char sChar = s.charAt(sIndex);
            char pChar = p.charAt(pIndex);

            if(pChar == '*'){
                pChar = p.charAt(pIndex - 1);
                if(pChar == '.'){

                }
                while(sChar == pChar){
                    sChar = s.charAt(++sIndex);
                }
            }

            if(pChar == '.'){
                continue;
            }

            if(pChar != sChar){
                return false;
            }


        }

        if(sIndex == s.length()-1 && pIndex == p.length()-1){
            return true;
        } else {
            return false;
        }

    }
    */

    /**
     * 使用动态规划解题，该步骤已无必要
     * */
    public static String dealPattern(String p){
        StringBuilder pattern = new StringBuilder(p);
        while(pattern.length() > 0 && pattern.charAt(0) == '*'){
            pattern.deleteCharAt(0);
        }

        int starIndex = pattern.indexOf("*");
        while(starIndex > 0){

            char com = pattern.charAt(starIndex - 1);
            while(starIndex + 1 < pattern.length() && com == pattern.charAt(starIndex + 1)){
                pattern.deleteCharAt(starIndex + 1);
            }

            starIndex = pattern.indexOf("*", starIndex + 1);
        }

        return pattern.toString();
    }

    public static boolean dpWay(String s, String p){
        int slength = s.length();
        int pLength = p.length();
        int[][] dp = new int[slength + 1][pLength + 1];

        for (int i = 0; i < slength + 1; i++) {
            dp[i][pLength] = 0;
        }
        dp[slength][pLength] = 1;

        for (int sIndex = slength; sIndex > -1 ; sIndex--) {
            for (int pIndex = pLength-1; pIndex > -1 ; pIndex--) {
                char sChar = sIndex<s.length()?s.charAt(sIndex):EMPTY_CHAR;
                char pChar = p.charAt(pIndex);
                if(pChar == '*'){
                    if(pIndex > 0){
                        // 持续匹配
                        char prePchar = p.charAt(pIndex-1);
                        if((prePchar == sChar || prePchar == OMNIPOTENT_CHAR) && sChar != EMPTY_CHAR){
                            dp[sIndex][pIndex] |= dp[sIndex + 1][pIndex];
                        }
                    }

                    // 终止匹配
                    dp[sIndex][pIndex] |= dp[sIndex][pIndex +1];

                } else {
                    if(pIndex < p.length()-1 && p.charAt(pIndex + 1) == '*'){   // 有资格不匹配
                        // 不匹配
                        dp[sIndex][pIndex] |= dp[sIndex][pIndex + 1];
                    }

                    if((sChar == pChar || pChar == OMNIPOTENT_CHAR) && sChar != EMPTY_CHAR){
                        // 匹配一个
                        dp[sIndex][pIndex] |= dp[sIndex + 1][pIndex + 1];
                    }
                }
            }
        }

        return dp[0][0] == 1;
    }

    public static boolean process(String s, int sIndex, String p, int pIndex, Map<String, Boolean> cache){
        if(sIndex >= s.length() && pIndex >= p.length()){
            return true;
        }
        if(pIndex >= p.length()){
            return false;
        }

        char sChar = sIndex<s.length()?s.charAt(sIndex):EMPTY_CHAR;
        char pChar = p.charAt(pIndex);

        boolean ans = false;
        if(pChar == '*'){
            if(pIndex > 0){
                // 持续匹配
                char prePchar = p.charAt(pIndex-1);
                if((prePchar == sChar || prePchar == OMNIPOTENT_CHAR) && sChar != EMPTY_CHAR){
                    boolean ta;
                    if(cache.containsKey((sIndex + 1) + SEPARATOR + pIndex)){
                        ta  = cache.get((sIndex + 1) + SEPARATOR + pIndex);
                    } else {
                        ta = process(s, sIndex + 1, p, pIndex, cache);
                        cache.put((sIndex + 1) + SEPARATOR + pIndex, ta);
                    }
                    ans |= ta;
                }
            }

            // 终止匹配
            boolean ta;
            if(cache.containsKey(sIndex + SEPARATOR + (pIndex + 1))){
                ta = cache.get(sIndex + SEPARATOR + (pIndex + 1));
            } else {
                ta = process(s, sIndex, p, pIndex +1, cache);
                cache.put(sIndex + SEPARATOR + (pIndex + 1), ta);
            }
            ans |= ta;

        } else {
            if(pIndex < p.length()-1 && p.charAt(pIndex + 1) == '*'){   // 有资格不匹配
                // 不匹配
                boolean ta;
                if(cache.containsKey(sIndex + SEPARATOR + (pIndex + 1))){
                    ta = cache.get(sIndex + SEPARATOR + (pIndex + 1));
                } else {
                    ta = process(s, sIndex, p, pIndex +1, cache);
                    cache.put(sIndex + SEPARATOR + (pIndex + 1), ta);
                }
                ans |= ta;
            }

            if((sChar == pChar || pChar == OMNIPOTENT_CHAR) && sChar != EMPTY_CHAR){
                // 匹配一个
                boolean ta;
                if(cache.containsKey((sIndex + 1) + SEPARATOR + (pIndex + 1))){
                    ta = cache.get((sIndex + 1) + SEPARATOR + (pIndex + 1));
                } else {
                    ta = process(s, sIndex + 1, p, pIndex +1, cache);
                    cache.put((sIndex + 1) + SEPARATOR + (pIndex + 1), ta);
                }
                ans |= ta;
//            } else {
//                // 失败
//                ans |= false;
            }
        }

        return ans;
    }



}
