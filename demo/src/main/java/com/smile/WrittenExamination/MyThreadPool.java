package com.smile.WrittenExamination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {

    private volatile boolean RUNNING = true;

    private boolean shutdown = false;

    private int poolSize; //工作线程数
    private int coreSize; //核心线程数

    private BlockingQueue<Runnable> queue; //任务等待队列

    private HashSet<Worker> workers = new HashSet<>();

    private List<Thread> pool = new ArrayList<>();

    public MyThreadPool(int coreSize){
        this.coreSize = coreSize;
        queue = new LinkedBlockingQueue<>(coreSize);
    }

    public void exec(Runnable runnable){
        if (runnable == null) throw new NullPointerException();
        //检查当前线程数是否达到核心线程数的限制
        if(poolSize < coreSize){
            addWorker(runnable);
        }else{
            try {
                queue.put(runnable); //尝试放到等待队列中
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addWorker(Runnable runnable) {
        poolSize++;
        Worker worker = new Worker(runnable);
        workers.add(worker);
        Thread thread = new Thread(worker); //直接创建一个核心线程
        pool.add(thread);
        thread.start(); //直接执行
    }

    public void shutdown(){
        RUNNING = false;
        if(!workers.isEmpty()){
            for(Worker worker : workers){
                worker.interruptIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }


    //内部类Worker是用来执行每个任务的
    class Worker implements Runnable{

        public Worker(Runnable task){
            queue.offer(task);
        }


        @Override
        public void run() {
            while(true && RUNNING){
                if(shutdown == true) Thread.interrupted();//用于停止接收任务
                Runnable task = null;
                try {
                    task = getTask();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Runnable getTask() throws InterruptedException{
            return queue.take();
        }

        public void interruptIfIdle(){
            for(Thread thread : pool){
                System.out.println(thread.getName() + " interrupt");
                thread.interrupt();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        MyThreadPool excutor = new MyThreadPool(3);
        for (int i = 0; i < 10; i++) {
            excutor.exec(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 在帮我干活");
                }
            });
        }
        excutor.shutdown();
    }





}
