package topic;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"aa","a"};
        System.out.println(nativeWay(strs));
    }


    /**
     * native way is smart way
     * */
    public static String nativeWay(String[] strs){
        if(strs == null || strs.length < 1){
            return "";
        }
        String candidate = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while(j < strs[i].length() && j < candidate.length() &&
                    candidate.charAt(j) == strs[i].charAt(j)){
                j++;
            }

            candidate = candidate.substring(0, j);
        }

        return candidate;
    }

}
