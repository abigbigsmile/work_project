package com.smile.WrittenExamination.shumei;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class ShuMei_1 {

    public static void main(String[] args) {
        findKeyWord();
    }

    public static void findKeyWord(){
        String pathName = "D:\\input.txt";
        String keyWordPath = "D:\\keyword.conf";
        FileReader fileReader = null;
        try {
            //读取关键字文件
            FileReader keyWordReader = new FileReader(keyWordPath);
            BufferedReader keyWordBufferedReader = new BufferedReader(keyWordReader);
            String keyWord = null;
            HashSet<String> set = new HashSet<>();
            //将关键字放入HashSet中
            while((keyWord = keyWordBufferedReader.readLine()) != null){
                keyWord.trim();
                set.add(keyWord);
            }
            //读取input文件
            fileReader = new FileReader(pathName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            HashMap<String, String> map = new HashMap<>();
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                line.trim();
                int index = line.indexOf(" ");
                String first = line.substring(0, index);
                //判断是否包含关键字
                for(String word : set){
                    if(first.contains(word)){
                        System.out.println(line);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
