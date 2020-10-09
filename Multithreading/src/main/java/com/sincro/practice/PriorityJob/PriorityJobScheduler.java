package com.sincro.practice.PriorityJob;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityJobScheduler {
    private ExecutorService jobPoolExecutor;
    private ExecutorService priorityJobScheduler = Executors.newSingleThreadExecutor();
    private PriorityBlockingQueue<Job> priorityBlockingQueue;

    public PriorityJobScheduler(int poolSize, int queueSize){
        jobPoolExecutor = Executors.newFixedThreadPool(poolSize);
        priorityBlockingQueue = new PriorityBlockingQueue<Job>(queueSize, Comparator.comparing(Job::getJobPriority));
        priorityJobScheduler.execute(()->{
            while(true){
                try{
                    jobPoolExecutor.execute(priorityBlockingQueue.take());
                } catch (InterruptedException e) {
                    System.out.println("No more jobs in pool.");
                    break;
                }
            }
        });

    }

    public void addJob(Job job){
        priorityBlockingQueue.add(job);
    }


    private void close(ExecutorService scheduler) {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }
    }

    public void closeScheduer(){
        close(priorityJobScheduler);
        close(jobPoolExecutor);
    }

    public int getQueuedTasksCount(){
        return priorityBlockingQueue.size();
    }

}
