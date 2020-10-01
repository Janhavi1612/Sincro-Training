package com.sincro.practice.ProducerConsumerWithCompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class WithCompletableFuture {
    private static List<Integer> sharedResources = new ArrayList<>();
    public static void main(String[] args) {

        for(int i=0;i<20;i++) {
            CompletableFuture.supplyAsync(() -> getList())
                    .thenApply(resources -> {
                        List<Integer> updatedResources = new ArrayList<>();
                        try {
                            updatedResources = ProducerConsumer.produce(resources);
                        } catch (InterruptedException e) {
                            System.out.println("Producer thread was interrupted.");
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
                            System.out.println("Consumer thread was interrupted.");
                        }
                    });
        }

    }

    private static List<Integer> getList() {
        return sharedResources;
    }
}
