package com.sincro.practice.ProducerConsumer;

public class WithThread {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Producer producer = new Producer(producerConsumer);
        Consumer consumer = new Consumer(producerConsumer);

        producer.start();
        consumer.start();

    }
}

