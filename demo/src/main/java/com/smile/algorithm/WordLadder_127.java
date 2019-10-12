package com.smile.algorithm;

import java.util.*;

public class WordLadder_127 {

    public static void main(String[] args) {
//        String[] strings = {"a","b","c"};
        String[] strings = {"hot","dot","dog","lot","log"};
        String beginWord = "hit", endWord="cog";
//        String beginWord = "a", endWord="c";

        List<String> wordList = Arrays.asList(strings);
        System.out.println(ladderLength(beginWord, endWord, wordList));
        System.out.println(ladderLength_bfs(beginWord, endWord, wordList));
        System.out.println(ladderLength_bidirectional_bfs(beginWord, endWord, wordList));
    }



    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord==null || endWord==null || beginWord.length()==0 || endWord.length() == 0) return 0;
        if(wordList == null || wordList.size() == 0) return 0;

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        int ladderLength = 1;
        while(!queue.isEmpty()){
            int num = queue.size();
            ladderLength ++;
            while(num-- > 0){
                String currentWord = queue.poll();
                for(String word : nextWordSet(currentWord, wordList)){
                    if(word.equals(endWord)) return ladderLength;
                    if(visited.contains(word)) continue;
                    else{
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }

        }
        return 0;
    }

    public static Set<String> nextWordSet(String currentWord, List<String> wordList){
        Set<String> nextWordSet = new HashSet<>();
        for(int i=0; i<currentWord.length(); i++){
            char[] crr = currentWord.toCharArray();
            for(char ch='a'; ch<='z'; ch++){
                crr[i] = ch;
                String temp = String.valueOf(crr);
                if(wordList.contains(temp)) nextWordSet.add(temp);
            }
        }
        return nextWordSet;
    }

    //单向BFS算法，使用队列
    public static int ladderLength_bfs(String beginWord, String endWord, List<String> wordList){
        //判断是否为空
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int ladderLength = 1;
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int num = queue.size();
            while (num-- > 0){
                String currentWord = queue.poll();
                for(int i=0; i<currentWord.length(); i++){
                    char[] crr = currentWord.toCharArray();
                    for(char ch='a'; ch<'z'; ch++){
                        crr[i] = ch;
                        String temp = String.valueOf(crr);
                        if(!visited.contains(temp) && wordList.contains(temp)){
                            if(temp.equals(endWord)) return ladderLength+1;
                            visited.add(temp);
                            queue.offer(temp);
                        }
                    }
                }
            }
            ladderLength ++;
        }
        return 0;
    }

    //双向BFS算法
    public static int ladderLength_bidirectional_bfs(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int ladderLength = 1;

        beginSet.add(beginWord);
        endSet.add(endWord);
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            Set<String> tempSet = new HashSet<>();
            for(String currentWord : beginSet){
                for(int i=0; i<currentWord.length(); i++){
                    for(char ch='a'; ch<'z'; ch++){
                        char[] crr = currentWord.toCharArray();
                        crr[i] = ch;
                        String temp = String.valueOf(crr);
                        if(endSet.contains(temp)) return ladderLength+1;
                        if(!visited.contains(temp) && wordList.contains(temp)){
                            tempSet.add(temp);
                            visited.add(temp);
                        }
                    }
                }
            }
            ladderLength ++; //层数+1
            beginSet = endSet;
            endSet = tempSet;
        }

        return 0;
    }

    //双向BFS优化
    public int ladderLength_bidirectional_bfs_x(String beginWord, String endWord, Set<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            //下面这一段直接影响了这种solution能否被AC
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}
