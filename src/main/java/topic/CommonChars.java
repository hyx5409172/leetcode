package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 1002
 * */
public class CommonChars {

    // 计数的方法更好
    public static void main(String[] args) {
        CommonChars commonChars = new CommonChars();
        String[] A = {"bella","label","roller"};

        System.out.println(commonChars.commonChars(A));
    }

    public List<String> commonChars(String[] A) {
        List<String> ans = new LinkedList<>();
        char[][] charList = new char[A.length][];
        int minLength = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < A.length; i++) {
            char[] tempChars = A[i].toCharArray();
            Arrays.sort(tempChars);
            charList[i] = tempChars;
            if(tempChars.length < minLength){
                minLength = tempChars.length;
                minIndex = i;
            }
        }

        int[] pointers = new int[A.length];
        // 字符挨个遍历
        boolean reachEnd = false;
        outer:
        for (int i = 0; i < minLength && !reachEnd; i++) {
            char tar = charList[minIndex][i];

            // debug
            System.out.println("开始下标：" + i + " 的检查，tar：" + tar);

            // char[] 挨个遍历是否包含指定字符串
            for (int j = 0,length = charList.length; j < length; j++) {
                int index = pointers[j];

                while(index < charList[j].length){
                    if(charList[j][index] == tar){
                        index ++;
                        pointers[j] = index;
                        // debug
                        System.out.println(j + " 号数组" + Arrays.toString(charList[j]) + " 匹配成功，组内下标：" + index);
                        break;
                    }

                    index ++;
                }

                if(pointers[j] == charList[j].length){
                    // debug
                    System.out.println(j + " 号数组" + Arrays.toString(charList[j]) + " 到达边界");
                    reachEnd = true;
                }

                // 当前数组中未匹配上，接下来均不用在匹配
                if(index != pointers[j]){
                    // debug
                    System.out.println(j + " 号数组" + Arrays.toString(charList[j]) + " 匹配失败");
                    continue outer;
                }


            }

            // 匹配成功
            ans.add(String.valueOf(tar));
        }

        return ans;
    }

//    public void copyVal(int[] origin, int[] recive){
//        for (int i = 0,length = origin.length; i < length; i++) {
//            recive[i] = origin[i];
//        }
//    }

}
