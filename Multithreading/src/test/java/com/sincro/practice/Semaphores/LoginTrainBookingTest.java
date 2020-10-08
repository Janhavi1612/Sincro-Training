package com.sincro.practice.Semaphores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LoginToStreamingServiceTest {
    private static int MAX_DEVICE_LIMIT = 5;
    private ExecutorService executorService;
    private LoginToStreamingService loginToStreamingService;

    @BeforeEach
    void setup(){
        executorService = Executors.newFixedThreadPool(MAX_DEVICE_LIMIT);
        loginToStreamingService = new LoginToStreamingService(MAX_DEVICE_LIMIT);
    }

    @Test
    public void shouldBlockLoginWhenMaxDeviceLimitReached(){
        IntStream.range(0, MAX_DEVICE_LIMIT)
                .forEach(user -> executorService.execute(loginToStreamingService::login));
        executorService.shutdown();

        assertEquals(0, loginToStreamingService.getHowManyMoreDevicesCanLogIn());
        assertFalse(loginToStreamingService.login());
    }
}