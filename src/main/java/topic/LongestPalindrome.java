package topic;

public class LongestPalindrome {


    public static void main(String[] args) {

        String testcase = "babad";
        System.out.println();
//        System.out.println(process(testcase, 0));
        System.out.println(way2(testcase));
    }

    /**
     * 以index为中心的回文
     * */
    public static String process(String s, double index){
        if(s == null || s.length() < 1){
            return s;
        }

        if(index == s.length() - 1){
            return s.substring(s.length() - 1);
        }

        int left = (int) Math.floor(index);
        int right = (int) Math.ceil(index);
        String ans = "";
        if(s.charAt(left) == s.charAt(right)){
            while(left-1 > -1 && right+1 < s.length()
                    && s.charAt(left-1) == s.charAt(right+1)){
                left--;
                right++;
            }
            ans = s.substring(left, right + 1);
        }

        String nextAns = process(s, index + 0.5);

        return nextAns.length() > ans.length()?nextAns:ans;
    }

    /**
     * 实在没有递归的必要
     * */
    public static String way2(String s){
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            ans = maxR(s, i, ans);
            ans = maxR(s, i + 0.5, ans);
        }

        return ans;
    }

    public static String maxR(String s, double index, String oriAns) {
        int left = (int) Math.floor(index);
        int right = (int) Math.ceil(index);

        if(left < 0 || right > s.length() - 1){
            return oriAns;
        }

        String ans = "";
        if(s.charAt(left) == s.charAt(right)){
            while(left-1 > -1 && right+1 < s.length()
                    && s.charAt(left-1) == s.charAt(right+1)){
                left--;
                right++;
            }
            ans = s.substring(left, right + 1);
        }
        ans = ans.length() > oriAns.length()?ans: oriAns;
        return ans;
    }

}
