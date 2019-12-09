package com.smile.algorithm;

import java.util.*;

public class WordLadderII_126 {
    public static void main(String[] args) {

        String beginWord = "hit";
        String  endWord = "cog";
        String[] strings = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList  = Arrays.asList(strings);
        List<List<String>> res = findLadders(beginWord, endWord, wordList);
        System.out.println();
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);//加快查询速度，contains——这一部至关重要

        List<List<String>> res = new ArrayList<>(); //用来返回结果
        Map<String, Integer> distance = new HashMap<>(); //用来计算level
        Map<String, List<String>> nextNodeList = new HashMap<>(); //用来记录当前节点以及对应的下一层节点集合
        List<String> onePathList = new ArrayList<>();
        distance.put(beginWord, 0);
        nextNodeList.put(beginWord, new ArrayList<>());
        createTree_bfs(beginWord, endWord, distance, nextNodeList, wordSet);
        //createTree_bidirectional_bfs(beginWord, endWord, distance, nextNodeList, wordSet);
        getPaths_dfs(beginWord,endWord, distance, nextNodeList, onePathList, res);
        return res;
    }

    private static void createTree_bfs(String beginWord, String endWord, Map<String, Integer> distance, Map<String, List<String>> nextNodeList, Set<String> wordSet) {
       for(String word : wordSet) nextNodeList.put(word, new ArrayList<>());

        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //BFS算法层序遍历，记录层数和下一节点集合
        while(!queue.isEmpty()){
            boolean found = false;
            int num = queue.size();
            while(num-- > 0){
                String currentWord = queue.poll();
                int level = distance.get(currentWord);
                List<String> nextNodes = nextWords(currentWord, wordSet);
                for(String word : nextNodes){
                    nextNodeList.get(currentWord).add(word);
                    if(!distance.containsKey(word)){
                        distance.put(word, level+1);
                        if(endWord.equals(word)) found = true;
                        else queue.offer(word);
                    }
                }
            }
            if(found) break;
        }
    }

    //双向BFS不适用这一题，路径会不同
    private static void createTree_bidirectional_bfs(String beginWord, String endWord, Map<String, Integer> distance, Map<String, List<String>> nextNodeList, Set<String> wordSet){
        for(String word : wordSet) nextNodeList.put(word, new ArrayList<>());

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = beginSet;
            }
            boolean found = false;
            Set<String> tempList = new HashSet<>();
            for(String currentWord : beginSet){
                List<String> nextWords = nextWords(currentWord, wordSet);
                int level = distance.get(currentWord);
                for(String word : nextWords){
                    nextNodeList.get(currentWord).add(word);
                    if(!distance.containsKey(word)){
                        distance.put(word, level+1);
                        if(word.equals(endWord)) found = true;
                        else tempList.add(word);
                    }
                }
                if(found) break;
            }
            beginSet = tempList;
        }
    }

    private static List<String> nextWords(String currentWord, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        char[] crr = currentWord.toCharArray();
        for(int i=0; i<currentWord.length(); i++){
            char old = crr[i];
            for(char ch='a'; ch<='z'; ch++){
                if(ch == old) continue;
                crr[i] = ch;
                String temp = String.valueOf(crr);
                if(wordSet.contains(temp)) list.add(temp);
            }
            crr[i] = old;
        }
        return list;
    }

    private static void getPaths_dfs(String currentWord, String endWord, Map<String, Integer> distance, Map<String, List<String>> nextNodeList, List<String> onePathList, List<List<String>> res) {
        onePathList.add(currentWord);
        if(currentWord.equals(endWord)){
              res.add(new ArrayList<>(onePathList));
        }else{
            for(String next : nextNodeList.get(currentWord)){
                // 注意点
                if(distance.get(currentWord)+1 == distance.get(next)){
                    getPaths_dfs(next, endWord, distance, nextNodeList, onePathList, res);
                }
            }
        }
        //注意点
        onePathList.remove(onePathList.size()-1); //注意：这一步是回溯
    }


}
