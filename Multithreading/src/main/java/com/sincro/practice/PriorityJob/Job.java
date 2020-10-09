package com.sincro.practice.PriorityJob;

public class Job implements Runnable {
    private String jobName;
    private JobPriority jobPriority;

    public Job(String jobName, JobPriority jobPriority) {
        this.jobName = jobName;
        this.jobPriority = jobPriority;
    }

    public JobPriority getJobPriority() {
        return jobPriority;
    }

    @Override
    public void run() {
        System.out.println("Job : "+this.jobName + " priority: "+ this.jobPriority + " runnimg.");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.print("Thread was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
