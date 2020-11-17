package topic;

import java.util.LinkedList;
import java.util.Queue;

public class ZString {

    public static void main(String[] args) {
        String s = "ABC";
        int numRows = 2;
        System.out.println(convert2(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if(s.length() ==0 || numRows == 1){
            return s;
        }
        int distance = numRows * 2 - 2;
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        StringBuilder ans = new StringBuilder();
        while(index < s.length()){
            ans.append(s.charAt(index));
            if(index > 0){
                queue.add(index - 1);
            }
            if(index + 1 < s.length()){
                queue.add(index + 1);
            }
            index += distance;
        }

        if(s.length() % distance != 1){
            queue.add(index - 1);
        }


        while(!queue.isEmpty()){
            int left = queue.poll();
            int right = queue.poll();

            if(left == right){
                ans.append(s.charAt(left));
                continue;
            }

            ans.append(s.charAt(left));
            if(right < s.length()){
                ans.append(s.charAt(right));
            }
            left++;
            right--;
            if(left > s.length() - 1){
                continue;
            }

            queue.add(left);
            queue.add(right);
        }

        return ans.toString();
    }

    public static String convert2(String s, int numRows){
        if(numRows == 1){
            return s;
        }
        String[] ans = new String[numRows];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = "";
        }
        int flag = 1;
        int curLine = 0;

        for (int i = 0; i < s.length(); i++) {
            ans[curLine] += s.charAt(i);
            curLine += flag;
            if(curLine % (numRows-1) == 0){
                flag = -flag;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
        }

        return sb.toString();
    }
}
