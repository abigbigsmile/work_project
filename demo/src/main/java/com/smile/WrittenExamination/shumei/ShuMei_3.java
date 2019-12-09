package com.smile.WrittenExamination.shumei;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class ShuMei_3 {

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
            HashSet<String> hashSet = new HashSet<>();
            String line = null;
            //逐段分割域名，把每一级域名放入到hashSet中
            while((line = bufferedReader.readLine()) != null){
                line.trim();
                int index = line.indexOf(".");
                if(index>=0) hashSet.add(line.substring(index+1));
            }
            //读取输入
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                String domain = scanner.nextLine();
                String sub = domain;
                int pos = -1;
                do{
                    sub = sub.substring(pos+1);
                    if(hashSet.contains(sub)){
                        System.out.println(domain + "\t" + "*."+sub);
                        break;
                    }
                    pos = sub.indexOf(".");
                }while (pos >= 0);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }


    }
}
