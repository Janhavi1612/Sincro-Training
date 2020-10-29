package com.sincro.practice;

import com.sincro.practice.callCentre.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


public class CallService {
    private static int NUMBER_OF_EMPLOYEES = 10;
    private static int NUMBER_OF_MANAGERS = 4;
    private static int NUMBER_OF_DIRECTORS = 2;

    private Agents employees;
    private Agents managers;
    private Agents directors;

    public CallService(){
        employees = new Agents(NUMBER_OF_EMPLOYEES, AgentRank.EMPLOYEE);
        managers = new Agents(NUMBER_OF_MANAGERS,AgentRank.MANAGER);
        directors = new Agents(NUMBER_OF_DIRECTORS, AgentRank.DIRECTOR);
    }

    public boolean dispatchCall(){
        boolean success = true;
        boolean employeeAttendedCall = transferCallToEmployee();
        if(!employeeAttendedCall){
            boolean managerAttendedCall = transferCallToManager();
            if(!managerAttendedCall){
                boolean directorAttendedCall = transferCallToDirector();
                if(!directorAttendedCall){
                    success = false;
                }
            }
        }
        return  success;
    }

    private void addCustomerToWaitingQueue() {

    }

    private boolean transferCallToManager() {
        if(managers.checkIfFreeAndAssignCall()) {
            return true;
        }
        else {
            System.out.println("All managers busy, Transferring call to director.");
            return false;
        }
    }

    private boolean transferCallToEmployee() {
        if(employees.checkIfFreeAndAssignCall()) {
            return true;
        }
        else {
            System.out.println("All employees busy, Transferring call to manager.");
            return false;
        }
    }

    private boolean transferCallToDirector() {
        if (directors.checkIfFreeAndAssignCall()) {
            return true;
        }
        else{
            System.out.println("Please wait, we will connect you to an agent as soon as they are available.");
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService customersExecutorService = Executors.newFixedThreadPool(17);
        CallService callService = new CallService();

        IntStream.range(0,17).forEach(customer -> customersExecutorService.execute(callService::dispatchCall));
        Thread.sleep(500);
        customersExecutorService.shutdown();

        ExecutorService newCall = Executors.newFixedThreadPool(5);
        IntStream.range(0,5).forEach(customer -> newCall.execute(callService::dispatchCall));
        newCall.shutdown();
    }

}