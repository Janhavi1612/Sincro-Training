package com.sincro.practice.ProducerConsumer;

public class Consumer extends Thread {
    private ProducerConsumer producerConsumer;


    Consumer(ProducerConsumer producerConsumer){
        this.producerConsumer = producerConsumer;
    }
    @Override
    public void run() {
        try {
            producerConsumer.consume();
        } catch (InterruptedException e) {
            System.out.println("ProducerConsumer thread was interrupted during the process.");
        }
    }

}
