package com.sincro.practice.ProducerConsumer;

public class Producer extends Thread {
    private ProducerConsumer producerConsumer;

    Producer(ProducerConsumer producerConsumer){
        this.producerConsumer = producerConsumer;
    }


    @Override
    public void run() {
        try {
            producerConsumer.produce();
        } catch (InterruptedException e) {
            System.out.println("ProducerConsumer thread was interrupted during the process.");
        }
    }

}
