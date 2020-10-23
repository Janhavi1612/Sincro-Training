package com.sincro.practice.callCentre;

import java.util.concurrent.Semaphore;

public class Managers {
    private Semaphore managerSemaphore;

    public Managers(int numberOfManagers){
        managerSemaphore = new Semaphore(numberOfManagers);
    }

    public boolean checkIfManagerAvailableAndAssignCal(){
        boolean managerAvailable = managerSemaphore.tryAcquire();
        if(managerAvailable){
            System.out.println("Customer: "+ Thread.currentThread() +" call attended by manager.");
        }
        else{
            System.out.println("All managers busy. Transferring call to Director.");
        }
        return managerAvailable;
    }

    public void endCall() {
        try {
            Thread.currentThread().sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Error occurred while disconnecting");
            Thread.currentThread().interrupt();
        }
        managerSemaphore.release();
    }
}
