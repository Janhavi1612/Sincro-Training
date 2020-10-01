package com.sincro.practice.producerConsumerWithCompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompletableFutureAndExecutorService {
    static Logger logger = Logger.getLogger(CompletableFutureAndExecutorService.class.getName());

    private static List<Integer> sharedResources = new ArrayList<>();
    private static List<Integer> getList() {
        return sharedResources;
    }

    public static void main(String[] args) {
        ExecutorService producersThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService consumersThreadPool = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++) {
            CompletableFuture.supplyAsync(CompletableFutureAndExecutorService::getList, producersThreadPool)
                    .thenApply(resources -> {
                        List<Integer> updatedResources = new ArrayList<>();
                        try {
                            updatedResources = ProducerConsumer.produce(resources);
                        } catch (InterruptedException e) {
                            logger.log(Level.INFO,"Producer thread was interrupted.");
                            Thread.currentThread().interrupt();
                        }
                        return updatedResources;
                    });
        }
        for (int i=0;i<10;i++) {
            CompletableFuture.supplyAsync(CompletableFutureAndExecutorService::getList, consumersThreadPool)
                    .thenAccept(resources -> {
                        try {
                            ProducerConsumer.consume(resources);
                        } catch (InterruptedException e) {
                            logger.log(Level.INFO,"Consumer thread was interrupted.");
                            Thread.currentThread().interrupt();
                        }
                    });
        }
    }
}
