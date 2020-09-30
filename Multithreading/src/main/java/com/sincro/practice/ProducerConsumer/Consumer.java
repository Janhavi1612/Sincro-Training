package com.sincro.practice.ProducerConsumerWithThread;

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
            e.printStackTrace();
        }
    }

}
