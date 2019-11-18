package com.smile.WrittenExamination;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ShuMei_4 {

    public static void main(String[] args) {
        calEntropy();
    }


    public static void calEntropy(){
        //读取文件
        String path = "D:\\input.txt";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            int count = 0;
            String deviceName = null;
            while((readLine=bufferedReader.readLine())!=null){
                readLine.trim();
                String[] strs = readLine.split(" ");
                //保存设备名
                if(count==0) deviceName = strs[0];
                //计算连接各wifimac的次数
                hashMap.put(strs[1], hashMap.getOrDefault(strs[1], 0)+1);
                //计算设备活跃的次数
                count++;
            }
            double res = 0;
            for(double times : hashMap.values()){
                double probability = times/count;
                res += probability*logUtil(probability, 2);
            }
            System.out.println(deviceName + "," + (-res));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    //计算对数
    public static double logUtil(double value, int basement){
        return Math.log(value)/Math.log(basement);
    }


}
