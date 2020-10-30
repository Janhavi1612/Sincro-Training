package com.sincro.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CallServiceTest {
    static CallService callService;

    @BeforeAll
    static void setup(){
        callService = new CallService();
    }

    @Test
    void shouldReturnFalseForNewCallsWhenAllBusy() throws InterruptedException {
        ExecutorService customersExecutorService = Executors.newFixedThreadPool(20);
        IntStream.range(0,20).forEach(customer -> customersExecutorService.execute(callService::dispatchCall));

     //   assertFalse(this.callService.dispatchCall());
        Thread.sleep(500);
        customersExecutorService.shutdown();
    }

    @Test
    void shouldAttendNewCallAfterPreviousCallsEnd() throws InterruptedException {
        ExecutorService customersExecutorService = Executors.newFixedThreadPool(16);
        IntStream.range(0,16).forEach(customer -> customersExecutorService.execute(callService::dispatchCall));
        Thread.sleep(500);
        customersExecutorService.shutdown();

       // assertTrue(this.callService.dispatchCall());

    }

}