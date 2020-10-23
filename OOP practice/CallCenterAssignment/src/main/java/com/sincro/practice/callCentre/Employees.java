package com.sincro.practice.callCentre;

import java.util.TreeMap;
import java.util.concurrent.Semaphore;

public class Employees {
    private Semaphore employeesSemaphore;

    public Employees(int numberOfEmployees){
        employeesSemaphore = new Semaphore(numberOfEmployees);
    }

    public boolean checkIfEmployeeAvailableAndAssignCall(){
        boolean employeeAvailable = employeesSemaphore.tryAcquire();

        if(employeeAvailable){
            System.out.println("Customer: "+ Thread.currentThread() +" call attended by employee.");
        }
        else{
            System.out.println("All Employees busy. Transferring call to Manager.");
        }
        return employeeAvailable;
    }

    public void endCall(){
        try {
            Thread.currentThread().sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Error occurred while disconnecting");
            Thread.currentThread().interrupt();
        }
        /*catch (IllegalMonitorStateException mse){
            System.out.println("Error occurred while disconnecting");
        }*/
        employeesSemaphore.release(1);
        //System.out.println("Customer: "+ Thread.currentThread()+"call disconnected.");
    }
}
