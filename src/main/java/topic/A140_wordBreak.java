package topic;

import java.util.*;
import java.util.stream.Collectors;

public class A140_wordBreak {

    public static void main(String[] args) {
        String[] dict = {"cat", "cats", "and", "sand", "dog"};
        String s = "catsanddog";
//        String[] dict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = Arrays.asList(dict);

        A140_wordBreak a140_wordBreak = new A140_wordBreak();
        List<String> ans = a140_wordBreak.wordBreak(s, wordDict);
        System.out.println(ans);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return strWay(s, wordDict);
    }

    public List<String> strWay(String s, List<String> wordDict){
        List<String> ans = new ArrayList<>();
        strWayProcess(s, 0, wordDict, new LinkedList<>(), ans, new int[s.length()][wordDict.size()]);
        return ans;
    }

    public void strWayProcess(String s, int index, List<String> wordDict, LinkedList<String> path, List<String> ans, int[][] computed){
        if(index == s.length()){
            ans.add(path.stream().collect(Collectors.joining(" ")));
            return;
        }

        int leftLength = s.length() - index;
        for (int i = 0,size = wordDict.size(); i < size; i++) {
            if(computed[index][i] == 1){
                continue;
            }
            String word = wordDict.get(i);
            int wordLength = word.length();
            if(wordLength > leftLength){
                continue;
            }
            if(s.indexOf(word, index) == index){
                // 能匹配上
                int ansNum = ans.size();
                path.add(word);
                strWayProcess(s, index + wordLength, wordDict, path, ans, computed);
                int newAnsNew = ans.size();
                if(ansNum == newAnsNew){
                    // 无答案
                    computed[index][i] = 1;
                }
                path.removeLast();
            }
        }
    }

}
