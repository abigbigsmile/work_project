package com.smile.WrittenExamination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ProducerConsumer_3 {

    private static Semaphore notFull = new Semaphore(10);
    private static Semaphore notEmpty = new Semaphore(10);
    private static Semaphore mutx = new Semaphore(1);
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
            for(int i=0; i<10; i++){
                try {
                    notFull.acquire();
                    mutx.acquire();
                    size++;
                    System.out.println(Thread.currentThread().getName() + "生产——" + size);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mutx.release();
                    notEmpty.release();
                }
            }
        }
    }



    static class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<10; i++){
                try {
                    notEmpty.acquire();
                    mutx.acquire();
                    size--;
                    System.out.println(Thread.currentThread().getName() + "消费—" + size);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mutx.release();
                    notFull.release();
                }
            }
        }
    }
}
