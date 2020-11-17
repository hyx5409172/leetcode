package topic;

import java.util.*;
import java.util.stream.Collectors;

public class A127_ladderLength {

    public static void main(String[] args) {
        A127_ladderLength a127 = new A127_ladderLength();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        wordList = new ArrayList<>(wordList);

        System.out.println(a127.ladderLength(beginWord, endWord, wordList));
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }

        Map<String,List<String>> transferIndex = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        Set<String> used = new HashSet<>();
        queue.offer(endWord);
        used.add(endWord);
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String s1 = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String s2 = wordList.get(j);
                    if(!used.contains(s2) && !s1.equals(s2) && canTransfer(s1, s2)){
                        transferIndex.computeIfAbsent(s1, k -> new ArrayList<>());
                        transferIndex.compute(s1, (k,v) -> {
                            v.add(s2);
                            return v;
                        });
                        queue.offer(s2);
                        used.add(s2);
                    }
                }
            }
        }


        int cur = 1;
        used.clear();
        queue.offer(endWord);
        used.add(endWord);
        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                if(beginWord.equals(curWord)){
                    return cur;
                }

                List<String> nextWords = transferIndex.get(curWord);
                if(nextWords != null){
                    nextWords.forEach(e -> {
                        if(!used.contains(e)){
                            queue.offer(e);
                            used.add(e);
                        }
                    });
                }
            }

            cur ++;
        }

        return 0;


//        path.push(beginWord);
//        process(beginWord, endWord, transferIndex, path);
//
//        if(minPath == Integer.MAX_VALUE){
//            minPath = 0;
//        }
//        return minPath;
    }

    int minPath = Integer.MAX_VALUE;
    public void process(String curWord, String tarWord, Map<String,List<String>> transferIndex, Stack<String> path){
        if(curWord.equals(tarWord)){
            minPath = Math.min(minPath, path.size());
            return;
        }

        List<String> wordList = transferIndex.get(curWord);
        for (int i = 0; i < wordList.size(); i++) {
            String nextWord = wordList.get(i);
            if(!path.contains(nextWord)){
                path.push(nextWord);
                process(nextWord, tarWord, transferIndex, path);
                path.pop();
            }
        }
    }

    public boolean canTransfer(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int diff = 0;
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] != chars2[i]){
                diff++;
                if(diff > 1){
                    return false;
                }
            }
        }

        return  true;
    }



}
