package com.sincro.practice.PriorityJob;

import org.junit.jupiter.api.Test;

class PriorityJobSchedulerTest {
    private static int POOL_SIZE = 2;
    private static int QUEUE_SIZE = 10;

    @Test
    public void shouldExecuteJobsPriorityWise(){

        Job job1 = new Job("Job1", JobPriority.LOW);
        Job job2 = new Job("Job2", JobPriority.MEDIUM);
        Job job3 = new Job("Job3", JobPriority.HIGH);
        Job job4 = new Job("Job4", JobPriority.MEDIUM);
        Job job5 = new Job("Job5", JobPriority.LOW);
        Job job6 = new Job("Job6", JobPriority.HIGH);


        PriorityJobScheduler priorityJobScheduler = new PriorityJobScheduler(POOL_SIZE,QUEUE_SIZE);

        priorityJobScheduler.addJob(job1);
        priorityJobScheduler.addJob(job2);
        priorityJobScheduler.addJob(job3);
        priorityJobScheduler.addJob(job4);
        priorityJobScheduler.addJob(job5);
        priorityJobScheduler.addJob(job6);


        while(priorityJobScheduler.getQueuedTasksCount() != 0);




        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        priorityJobScheduler.closeScheduer();

    }

}