package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {


    public static void main(String[] args) {

        int n = 5;
        List<int[]> ans = new ArrayList<>();
        process(ans, n, new int[n], 0);
        List<List<String>> result = getResult(ans);
        result.forEach(anss -> {
            System.out.println("answer:");
            anss.forEach(System.out::println);
        });
    }

    public static void process(List<int[]> ans ,int n, int[] queens, int line){
        if(line == n){
            ans.add(Arrays.copyOf(queens, n));
            return ;
        }

        int lineStatus = 0;
        for (int i = 0; i < line; i++) {
            int lineStatusTemp = queens[i];
            int offset = line - i;
            lineStatus |= lineStatusTemp;
            lineStatus |= lineStatusTemp >> offset;
            lineStatus |= lineStatusTemp << offset;
        }

        int table = (1<<n) - 1;
        lineStatus &= table;

        if(lineStatus == table){
            return ;
        }

        while(lineStatus < table){
            int queen = (((~lineStatus) - 1) & lineStatus) + 1;
            queens[line] = queen;
            process(ans, n, queens, line + 1);
            lineStatus ^= queen;
        }

    }

//    public static String getLineString(int n, int bitNum){
//        StringBuilder sb = new StringBuilder();
//        sb.append(Integer.toBinaryString(bitNum));
//        while(sb.length() < n){
//            sb.insert(0, "0");
//        }
//
//        return sb.toString().replaceAll("0", ".").replaceAll("1","Q");
//    }

    public static String getLineString(int n, int bitNum){
        int index = Integer.bitCount(bitNum - 1);
        char[] c = new char[n];
        Arrays.fill(c, '.');;
        c[index] = 'Q';

        return new String(c);
    }



    public static List<List<String>> getResult(List<int[]> bitMap){
        List<List<String>> ans = new ArrayList<>();
        bitMap.forEach(queens -> {
            int length = queens.length;
            List<String> oneAns = new ArrayList<>();
            ans.add(oneAns);
            for (int i = 0; i < length; i++) {
                oneAns.add(getLineString(length ,queens[i]));
            }
        });

        return ans;
    }


}
