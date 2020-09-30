package com.sincro.practice;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++)
        {
            Future<Integer> future = executorService.submit(new Task());
            Integer result = future.get();
            System.out.println("Result from task is :"+result);
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MILLISECONDS);

    }
    static class Task implements Callable<Integer>{

        public Integer call() {
            System.out.println("\nCurrent Thread : "+ Thread.currentThread());
            return new Random().nextInt(50);
        }
    }
}

