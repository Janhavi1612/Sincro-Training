package com.sincro.practice;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        String[] springConfig = {"spring/jobs/job-config.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

        Job job = (Job) context.getBean("demoJob");
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

        JobExecution execution;
        try {
            execution = jobLauncher.run(job, new JobParameters());
        } catch (Exception e) {
            System.out.println("Error occurred while executing the job.");
        }
        System.out.println("Done.");

    }


}
