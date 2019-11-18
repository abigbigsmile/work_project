package com.smile.WrittenExamination;

import com.google.gson.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShuMei_5 {


    public static void main(String[] args) {

        String s1 = "{\n" +
                "'organization':'shumei ',\n" +
                "'type': 'tech',\n" +
                "'features':{\n" +
                "     'timestamp': 1558031759,\n" +
                "         'cities':['BeiJing','ShangHai','ShenZhen'],\n" +
                "         'apps':[{'name':'TianWang', 'date':'2018-01'},\n" +
                " {'name':'TianJing', 'date':'2016-01'}]\n" +
                "}\n" +
                "}";

        String s2 = "{\n" +
                "        'organization':'string',\n" +
                "        'type':'string',\n" +
                "        'features':{\n" +
                "            'timestamp':'long',\n" +
                "            'cities':['string'],\n" +
                "            'apps':[{'name':'string', 'date':'string'}]\n" +
                "        }\n" +
                "}";
        Gson gson = new Gson();
        JsonObject jsonObject1 = new JsonParser().parse(s1).getAsJsonObject();
        JsonObject jsonObject2 = new JsonParser().parse(s2).getAsJsonObject();
        System.out.println(judgeJson(jsonObject1, jsonObject2));
    }

    // BFS遍历
    public static boolean judgeJson(JsonObject jo1, JsonObject jo2){
        Set<Map.Entry<String, JsonElement>> set1 = jo1.entrySet();
        Set<Map.Entry<String, JsonElement>> set2 = jo2.entrySet();
        if(set1.size()!=set2.size()) return false;
        Iterator<Map.Entry<String, JsonElement>> it1 = set1.iterator();
        Iterator<Map.Entry<String, JsonElement>> it2 = set2.iterator();
        while(it1.hasNext() && it2.hasNext()){
            Map.Entry<String, JsonElement> entry1 = it1.next();
            Map.Entry<String, JsonElement> entry2 = it2.next();
            //key不相等
            if(!entry1.getKey().equals(entry2.getKey())) return false;
            else{
                if(entry1.getValue().isJsonObject() && entry2.getValue().isJsonObject()) judgeJson(entry1.getValue().getAsJsonObject(), entry2.getValue().getAsJsonObject());
                if(!doJudge(entry1.getValue(), entry2.getValue())) return false;
            }
        }
        return true;
    }

    public static boolean doJudge(JsonElement e1, JsonElement e2){
        //判断是否是jsonObject
//        if(e1.isJsonObject() && e2.isJsonObject()) return judgeJson(e1.getAsJsonObject(), e2.getAsJsonObject());
//        if(e1.isJsonObject() || e2.isJsonObject()) return false;

        boolean res = true;
        //判断是否是JsonArray
        if(e1.isJsonArray() && e2.isJsonArray()){
            JsonArray array1 = e1.getAsJsonArray();
            JsonArray array2 = e2.getAsJsonArray();
            for(int i=0; i<array1.size(); i++){
                if(array1.get(i).isJsonObject()) res = res && judgeJson(array1.getAsJsonObject(), array2.get(0).getAsJsonObject());
                else res = res && doJudge(array1.get(i), array2.get(0));
            }
        }
        if(!res)return false;
        if(e1.isJsonArray() || e2.isJsonArray()) return false;


        //判断是否是java基本类型
        if(e1.isJsonPrimitive() && e2.isJsonPrimitive()){
            JsonPrimitive jp1 = e1.getAsJsonPrimitive();
            JsonPrimitive jp2 = e2.getAsJsonPrimitive();
            if(jp1.isString() && jp2.isString()) return jp2.getAsString().equals("string");
            if(jp1.isString()) return false;

            if(jp1.isNumber() && jp2.isString()) return jp2.getAsString().equals("long");
            if(jp2.isNumber()) return false;
        }
        if(e1.isJsonPrimitive() || e2.isJsonPrimitive()) return false;
        return res;
    }
}
