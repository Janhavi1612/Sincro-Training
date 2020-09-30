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
            System.out.println("Producer thread was interrupted during the process.");
        }
    }

}
