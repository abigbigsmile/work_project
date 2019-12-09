package com.smile.WrittenExamination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ProducerConsumer_1 {

    private static final int FULL = 10;
    private static final int EMPTY = 0;
    private static String LOCk = "lock";
    private static int size = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for(int i=0; i<20; i++){
            if(i%2==0) executorService.execute(new Producer());
            else executorService.execute(new Consumer());
        }
        executorService.shutdown();

    }

    static class Producer implements Runnable{

        @Override
        public void run() {
            for(int i=0; i<20; i++){
                //首先获取锁
                synchronized(LOCk){
                    while(size==FULL){
                        try {
                            LOCk.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    size++;
                    System.out.println(Thread.currentThread().getName() + "生产——" + size);
                    LOCk.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<20; i++){
                synchronized (LOCk){
                    while(size==EMPTY){
                        try {
                            LOCk.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    size--;
                    System.out.println(Thread.currentThread().getName() + "消费——" + size);
                    LOCk.notifyAll();
                }
            }
        }
    }
}
