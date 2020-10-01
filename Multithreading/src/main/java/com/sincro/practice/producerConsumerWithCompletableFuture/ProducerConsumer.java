package com.sincro.practice.producerConsumerWithCompletableFuture;

import java.util.List;
import java.util.Random;

public class ProducerConsumer {

    private static final int MAX_SIZE = 10;
    private static Object notFull = new Object();
    private static Object notEmpty = new Object();

    public static List<Integer> produce(List<Integer> resources) throws InterruptedException {

        while (resources.size() == MAX_SIZE) {
                notFull.wait();
        }
        resources.add(new Random().nextInt(10));
        System.out.println("Producer thread: "+Thread.currentThread() +"Updated resources: " +resources.toString());
        notEmpty.notifyAll();

        return resources;
    }


    public static void consume(List<Integer> resources) throws InterruptedException {

        while (resources.isEmpty()) {
            notEmpty.wait();
        }
        resources.remove(0);
        System.out.println("Consumer thread: "+Thread.currentThread() +" Updated resources : " +resources.toString());
        notFull.notifyAll();

    }
}
