package com.sincro.practice.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    List<Integer> resources = new ArrayList<Integer>();
    int capacity = 5;

    public void produce() throws InterruptedException {
        int value=0;
        while(true){
            synchronized (this){
                while(resources.size() == capacity){
                    wait();
                }
                System.out.println("Producer produced: "+value);
                resources.add(value);

                value = (value+1)%capacity;

                notifyAll();
                Thread.sleep(100);
            }
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while (resources.size() == 0) {
                    wait();
                }
                int value = resources.remove(0);
                System.out.println("Consumer consumed: " + value);
                notifyAll();
                Thread.sleep(100);

            }
        }
    }
}
