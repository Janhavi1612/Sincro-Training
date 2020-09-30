package com.sincro.practice.ProducerConsumerWithThread;

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
            e.printStackTrace();
        }
    }

}
