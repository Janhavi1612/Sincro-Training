package com.sincro.practice;

import com.sincro.practice.callCentre.Directors;
import com.sincro.practice.callCentre.Employees;
import com.sincro.practice.callCentre.Managers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


public class CallService {
    private static int NUMBER_OF_EMPLOYEES = 10;
    private static int NUMBER_OF_MANAGERS = 4;
    private static int NUMBER_OF_DIRECTORS = 2;

    private Employees employees;
    private Managers managers;
    private Directors directors;

    public CallService(){
        employees = new Employees(NUMBER_OF_EMPLOYEES);
        managers = new Managers(NUMBER_OF_MANAGERS);
        directors = new Directors(NUMBER_OF_DIRECTORS);
    }

    public boolean dispatchCall(){
        if(employees.checkIfEmployeeAvailableAndAssignCall()){
            employees.endCall();
            return true;
        }
        else if(managers.checkIfManagerAvailableAndAssignCal()) {
            managers.endCall();
            return true;

        }
        else if(directors.checkIfDirectorAvailableAndAssignCall()){
            directors.endCall();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final ExecutorService customersExecutorService = Executors.newFixedThreadPool(16);
        CallService callService = new CallService();

        IntStream.range(0,16).forEach(customer -> customersExecutorService.execute(callService::dispatchCall));

        customersExecutorService.shutdown();
    }

}
