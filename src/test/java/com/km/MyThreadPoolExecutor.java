package com.km;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPoolExecutor {

    private volatile boolean RUNNING = true;
    private final ReentrantLock lock = new ReentrantLock();
    private final HashSet<Worker> workers = new HashSet<>();
    private static BlockingQueue<Runnable> queue = null;
    private final ArrayList<Thread> threads = new ArrayList<>();
    private volatile int poolsize;
    private volatile int coresize;
    private volatile boolean shutdown = false;

    public void execure(Runnable command) {
        if (command == null)
            throw new NullPointerException();
        if (coresize < poolsize) {
            addThread(command);
        } else {
            try {
                queue.put(command);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addThread(Runnable task) {
        lock.lock();
        try {
            coresize++;
            Worker worker = new Worker(task);
            workers.add(worker);
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }finally {
            lock.unlock();
        }
    }

    private final class Worker implements Runnable {

        public Worker(Runnable task) {
            queue.offer(task);
        }

        @Override
        public void run() {
            while (RUNNING) {
                if (shutdown) {
                    Thread.interrupted();
                }
                Runnable task = null;
                try {
                    task = getTask();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Runnable getTask() throws InterruptedException {
            return queue.take();
        }

        public void interruptIfIdle(){
            for(Thread thread:threads){
                System.out.println(thread.getName()+" interrupt");
                thread.interrupt();
            }
        }
    }

    public void shutdown(){
        RUNNING = false;
        if(!workers.isEmpty()){
            for(Worker worker:workers){
                worker.interruptIfIdle();
            }
        }
    }


}
