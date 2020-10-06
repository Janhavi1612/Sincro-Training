package com.sincro.practice.producerConsumerWithCompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompletableFutureAndExecutorService {
    private static Logger logger = Logger.getLogger(CompletableFutureAndExecutorService.class.getName());

    private static List<Integer> sharedResources = new ArrayList<>();
    private static List<Integer> getSharedResources() {
        return sharedResources;
    }

    public List<Integer> runProducerConsumerAndGetResources(){
        ExecutorService producersThreadPool = Executors.newFixedThreadPool(2);
        ExecutorService consumersThreadPool = Executors.newFixedThreadPool(2);
        startProducer(producersThreadPool);
        startConsumer(consumersThreadPool);

        stopProducerThreads(producersThreadPool);
        stopConsumerThreads(consumersThreadPool);

        return sharedResources;
    }


    private static void startConsumer(ExecutorService consumersThreadPool) {
        for (int i=0;i<10;i++) {
            CompletableFuture.supplyAsync(CompletableFutureAndExecutorService::getSharedResources, consumersThreadPool)
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

    private static void startProducer(ExecutorService producersThreadPool) {
        for(int i=0;i<10;i++) {
            CompletableFuture.supplyAsync(CompletableFutureAndExecutorService::getSharedResources, producersThreadPool)
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


    }

    private void stopConsumerThreads(ExecutorService consumersThreadPool) {
        try {
            consumersThreadPool.awaitTermination(15, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            logger.log(Level.INFO,"Consumer threads didn't shutdown.");
            consumersThreadPool.shutdownNow();
        }
    }

    private void stopProducerThreads(ExecutorService producersThreadPool) {
        try {
            producersThreadPool.awaitTermination(15, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            logger.log(Level.INFO,"Producer threads didn't shutdown.");
            producersThreadPool.shutdownNow();
        }
    }

}
