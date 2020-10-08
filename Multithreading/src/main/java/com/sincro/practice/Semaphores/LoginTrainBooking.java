package com.sincro.practice.Semaphores;

import java.util.concurrent.Semaphore;

public class LoginTrainBooking {
    private Semaphore semaphore;

    public LoginTrainBooking(int maxUsersAtATime){
        semaphore = new Semaphore(maxUsersAtATime);
    }

    public boolean login(){
        boolean tryLogin = semaphore.tryAcquire();

        if(tryLogin){
            System.out.println(Thread.currentThread() + " is logged in.");
        }
        else{
            System.out.println(Thread.currentThread() + " could not log in. Maximum number of device logins at a time reached.");
        }
        return tryLogin;
    }



    public void logout(){
        semaphore.release();
        System.out.println(Thread.currentThread() + " is logged out.");
    }

    public int getHowManyMoreDevicesCanLogIn(){
        return semaphore.availablePermits();
    }

    public void lockBookingFacility(){
         semaphore.drainPermits();
    }



}
