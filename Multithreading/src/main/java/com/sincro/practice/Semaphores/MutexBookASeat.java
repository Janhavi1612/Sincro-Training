package com.sincro.practice.Semaphores;

import java.util.concurrent.Semaphore;

public class MutexBookASeat {
    private Semaphore mutexForBookingASeat;

    public MutexBookASeat(){
        mutexForBookingASeat = new Semaphore(1);
    }

    public void bookSeat() throws InterruptedException {

        System.out.println(Thread.currentThread() + " is booking the seat.");
        mutexForBookingASeat.acquire();
        System.out.println(Thread.currentThread() + " booked a seat.");
        Thread.sleep(100);

        mutexForBookingASeat.release();

    }

    public boolean hasWaitingUsers(){
        return mutexForBookingASeat.hasQueuedThreads();
    }
}
