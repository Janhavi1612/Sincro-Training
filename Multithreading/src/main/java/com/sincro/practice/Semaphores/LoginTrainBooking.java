package com.sincro.practice.Semaphores;

import java.util.concurrent.Semaphore;

public class LoginToStreamingService {
    private Semaphore semaphore;

    public LoginToStreamingService(int maxDevicesAtATime){
        semaphore = new Semaphore(maxDevicesAtATime);
    }

    public boolean login(){
        boolean tryLogin = semaphore.tryAcquire();
        if(tryLogin){
            System.out.println(Thread.currentThread() + " is logged in.");
        }
        else{
            System.out.println(Thread.currentThread() + " could not log in.");
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


}
