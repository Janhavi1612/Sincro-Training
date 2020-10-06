package com.sincro.practice.producerConsumerWithCompletableFuture;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CompletableFutureAndExecutorServiceTest {
    private static CompletableFutureAndExecutorService test;

    @BeforeAll
    private static void setup(){
        test = new CompletableFutureAndExecutorService();
    }

    @Test
    void shouldReturnEmptyListAfterCompletion(){
        assertTrue(test.runProducerConsumerAndGetResources().isEmpty());
    }

}