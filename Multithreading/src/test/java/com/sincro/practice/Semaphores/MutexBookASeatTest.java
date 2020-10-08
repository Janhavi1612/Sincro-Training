package com.sincro.practice.Semaphores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MutexBookASeatTest {

    private ExecutorService executorService;
    private MutexBookASeat mutexBookASeat;

    @BeforeEach
    void setup(){
        executorService = Executors.newFixedThreadPool(5);
        mutexBookASeat = new MutexBookASeat();
    }

    @Test
    void shouldAllowOneThreadToBookAtATime() throws InterruptedException {

        mutexBookASeat.bookSeat();

        IntStream.range(0, 5)
                .forEach(user -> executorService.execute(() -> {
                    try {
                        mutexBookASeat.bookSeat();
                    }catch(InterruptedException ie){
                        System.out.print("Thread was interrupted while booking.");
                    }
                }));
        executorService.shutdown();
        assertTrue(mutexBookASeat.hasWaitingUsers());

        Thread.sleep(500);
        assertFalse(mutexBookASeat.hasWaitingUsers());
    }
}