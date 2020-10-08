package com.sincro.practice.producerConsumerWithLockAPI;

import com.sincro.practice.producerConsumerWithCompletableFuture.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class WithLockAPI {
    private static Logger logger = Logger.getLogger(WithLockAPI.class.getName());

    private static List<Integer> sharedResources = new ArrayList<>();
    private static List<Integer> getSharedResources() {
        return sharedResources;
    }

    public List<Integer> runProducerConsumer(){
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
            CompletableFuture.supplyAsync(WithLockAPI::getSharedResources, consumersThreadPool)
                    .thenAccept(resources -> {
                        try {
                            com.sincro.practice.producerConsumerWithCompletableFuture.ProducerConsumer.consume(resources);
                        } catch (InterruptedException e) {
                            logger.log(Level.INFO,"Consumer thread was interrupted.");
                            Thread.currentThread().interrupt();
                        }
                    });
        }
    }

    private static void startProducer(ExecutorService producersThreadPool) {
        for(int i=0;i<10;i++) {
            CompletableFuture.supplyAsync(WithLockAPI::getSharedResources, producersThreadPool)
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

    private static void stopConsumerThreads(ExecutorService consumersThreadPool) {
        try {
            consumersThreadPool.awaitTermination(15, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            logger.log(Level.INFO,"Consumer threadpool did not shutdown after 15 ms.");
            Thread.currentThread().interrupt();
            consumersThreadPool.shutdownNow();
        }
    }

    private static void stopProducerThreads(ExecutorService producersThreadPool) {
        try {
            producersThreadPool.awaitTermination(15, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            logger.log(Level.INFO,"Producer threadpool did not shutdown after 15 ms.");
            Thread.currentThread().interrupt();
            producersThreadPool.shutdownNow();
        }
    }
}
