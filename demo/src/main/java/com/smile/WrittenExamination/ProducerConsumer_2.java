package com.smile.WrittenExamination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer_2 {

    private static final int FULL = 10;
    private static final int EMPTY = 0;
    private static Lock lock = new ReentrantLock();
    private static final Condition fullCondition = lock.newCondition();
    private static final Condition emptyCondition = lock.newCondition();
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
                lock.lock();
                try {
                    while(size==FULL){
                        try {
                            fullCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    size++;
                    System.out.println(Thread.currentThread().getName() + "生产——" + size);
                    emptyCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<20; i++){
                lock.lock();
                try {
                    while(size==EMPTY){
                        try {
                            emptyCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    size--;
                    System.out.println(Thread.currentThread().getName() + "消费——" + size);
                    fullCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
