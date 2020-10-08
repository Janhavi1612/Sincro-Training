package com.sincro.practice.producerConsumerWithLockAPI;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class ProducerConsumer {

    private static int MAXCAPACITY = 5;
    private Logger logger = Logger.getLogger(getClass().getName());

    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmptyCondition = lock.newCondition();
    private Condition notFullCondition = lock.newCondition();

    public List<Integer> produce(List<Integer> resources){
        int value=0;

        lock.lock();
        try {
            while (resources.size() == MAXCAPACITY) {
                notFullCondition.await();
            }
            System.out.println("Producer thread: "+Thread.currentThread() +"Updated resources: " +resources.toString());
            resources.add(value);
            value++;

            notEmptyCondition.signalAll();
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
                logger.log(Level.INFO,"Producer thread was interrupted.");
                Thread.currentThread().interrupt();
        }
        finally {
            lock.unlock();
        }
        return resources;
    }

    public void consume(List<Integer> resources){
        lock.lock();

        try{
            while(resources.isEmpty()){
                notEmptyCondition.await();
            }
            resources.remove(0);
            System.out.println("Consumer thread: "+Thread.currentThread() +" Updated resources : " +resources.toString());
            notFullCondition.signalAll();
        }catch (InterruptedException e){
            logger.log(Level.INFO,"Consumer thread was interrupted.");
            Thread.currentThread().interrupt();
        }
        finally{
            lock.unlock();
        }
    }
}
