package com.sincro.practice.producerConsumerWithLockAPI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WithLockAPITest {
    private static WithLockAPI test;

    @BeforeAll
    private static void setup(){
        test = new WithLockAPI();
    }

    @Test
    void shouldReturnEmptyListOnCompletion(){
        assertTrue(test.runProducerConsumer().isEmpty());
    }
}