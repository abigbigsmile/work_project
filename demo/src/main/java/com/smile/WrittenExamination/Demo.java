package com.smile.WrittenExamination;

public class Demo {

    private static Demo demo = new Demo();
    private static Demo demo2 = null;

    private Demo(){}

    public static Demo getInstance(){
        return demo;
    }

    public static Demo getInstance2(){
        if(demo2 == null) demo = new Demo();
        return demo;
    }
}
