package com.smile.WrittenExamination.shumei;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class ShuMei_2 {

    public static void main(String[] args) {
        findKeyWord();
    }

    public static void findKeyWord(){

        int[] arr = new int[1000];

        String pathName = "D:\\input.txt";
        FileReader fileReader = null;
        try {
            //读取input文件
            fileReader = new FileReader(pathName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            //计算各个范围内出现的次数
            while((line = bufferedReader.readLine()) != null){
                line.trim();
                int num = Integer.valueOf(line);
                arr[num/100]++;
            }
            //按格式输出
            for(int i=0; i<arr.length; i++){
                System.out.println(i*100 + "-" + ((i+1)*100-1) + " " + arr[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }


    }
}
