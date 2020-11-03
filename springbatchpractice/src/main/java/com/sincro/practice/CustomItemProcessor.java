package com.sincro.practice;

import com.sincro.practice.model.Report;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Report, Report> {
    public Report process(Report report) throws Exception {
        System.out.println("Processing report: "+ report);
        return report;
    }
}
