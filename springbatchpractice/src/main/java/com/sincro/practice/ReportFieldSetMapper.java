package com.sincro.practice;

import com.sincro.practice.model.Report;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportFieldSetMapper implements FieldSetMapper<Report> {
    static Report report;
    private SimpleDateFormat dateFormatObj = new SimpleDateFormat("dd/MM/yyyy");
    public Report mapFieldSet(FieldSet fieldSet) throws BindException {
        report = new Report();
        report.setId(fieldSet.readInt(0));
        report.setSales(fieldSet.readLong(1));
        report.setQuantity(fieldSet.readInt(2));
        report.setStaffName(fieldSet.readString(3));

        String csvDate = fieldSet.readString(4);
        try {
            report.setDate(dateFormatObj.parse(csvDate));
        } catch (ParseException parseExceptionObj) {
            parseExceptionObj.printStackTrace();
        }

        return report;
    }
}
