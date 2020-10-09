package com.sincro.practice.PriorityJob;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityJobScheduler {
    private ExecutorService jobPoolExecutor;
    private ExecutorService priorityJobScheduler = Executors.newSingleThreadExecutor();
    private PriorityBlockingQueue<Job> priorityBlockingQueue;

    public PriorityJobScheduler(int totalJobs, int queueSize){
        jobPoolExecutor = Executors.newFixedThreadPool(totalJobs);
        priorityBlockingQueue = new PriorityBlockingQueue<Job>(
                queueSize,
                Comparator.comparing(Job::getJobPriority));

        priorityJobScheduler.execute(()->{
            while(true){
                try{
                    priorityJobScheduler.execute(priorityBlockingQueue.take());
                } catch (InterruptedException e) {
                    System.out.print("thread was interrupted.");
                    break;
                }
            }
        });
    }

    public void scheduleJob(Job job){
        priorityBlockingQueue.add(job);
    }

}
