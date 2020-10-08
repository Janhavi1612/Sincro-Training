package com.sincro.practice.Semaphores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTrainBookingTest {
    private static int MAX_USERS_AT_A_TIME = 5;
    private ExecutorService executorService;
    private LoginTrainBooking loginTrainBooking;

    @BeforeEach
    void setup(){
        executorService = Executors.newFixedThreadPool(MAX_USERS_AT_A_TIME);
        loginTrainBooking = new LoginTrainBooking(MAX_USERS_AT_A_TIME);
    }

    @Test
    public void shouldBlockLoginWhenMaxDeviceLimitReached(){
        IntStream.range(0, MAX_USERS_AT_A_TIME+2)
                .forEach(user -> executorService.execute(loginTrainBooking::login));
        executorService.shutdown();

        assertEquals(0, loginTrainBooking.getHowManyMoreDevicesCanLogIn());
        assertFalse(loginTrainBooking.login());
    }

    @Test
    public void shouldAllowLoginWhenSlotAvailable(){
        IntStream.range(0, MAX_USERS_AT_A_TIME-1)
                .forEach(user -> executorService.execute(loginTrainBooking::login));
        executorService.shutdown();

        assertTrue(loginTrainBooking.login());
    }

    @Test
    public void adminCanLockTheService(){
        loginTrainBooking.lockBookingFacility();
        System.out.println("Booing facility closed by admin.");

        assertFalse(loginTrainBooking.login());
    }



}