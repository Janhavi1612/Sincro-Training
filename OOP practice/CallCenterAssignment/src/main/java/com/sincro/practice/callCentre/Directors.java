package com.sincro.practice.callCentre;

import java.util.concurrent.Semaphore;

public class Directors {
    private Semaphore directorSemaphore;

    public Directors(int numberOfDirectors){
        directorSemaphore = new Semaphore(numberOfDirectors);
    }

    public boolean checkIfDirectorAvailableAndAssignCall(){
        boolean directorAvailable = directorSemaphore.tryAcquire();
        if(directorAvailable){
            System.out.println("Customer: "+ Thread.currentThread() +" call attended by director.");
        }
        else{
            System.out.println("All directors busy. Please call after some time.");
        }
        return directorAvailable;
    }

    public void endCall() {
        try {
            Thread.currentThread().sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Error occurred while disconnecting");
            Thread.currentThread().interrupt();
        }
        directorSemaphore.release();
    }
}
