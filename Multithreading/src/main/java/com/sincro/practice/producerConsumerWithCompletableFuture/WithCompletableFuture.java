package com.sincro.practice.producerConsumerWithCompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WithCompletableFuture {
    static Logger logger = Logger.getLogger(CompletableFutureAndExecutorService.class.getName());

    private static List<Integer> sharedResources = new ArrayList<>();
    private static List<Integer> getList() {
        return sharedResources;
    }

    public static void main(String[] args) {

        for(int i=0;i<20;i++) {
            CompletableFuture.supplyAsync(() -> getList())
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
        for(int i=0;i<20;i++) {
            CompletableFuture.supplyAsync(() -> getList())
                    .thenAccept(list -> {
                        try {
                            ProducerConsumer.consume(getList());
                        } catch (InterruptedException e) {
                            logger.log(Level.INFO,"Consumer thread was interrupted.");
                            Thread.currentThread().interrupt();
                        }
                    });
        }

    }


}
