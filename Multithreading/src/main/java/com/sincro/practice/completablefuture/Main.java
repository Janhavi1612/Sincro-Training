package com.sincro.practice.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Order {
    private static int getOrder(){
        System.out.println("Processing thread: "+Thread.currentThread());
        System.out.println("Order fetched.");
        return new Random().nextInt(10);
    }
    private static int processPayment(int productNumber){
        System.out.println("Payment processed.");
        return productNumber * 10;
    }
    private void dispatchOrderToDriver(){
        System.out.println("Order dispatched to the driver.");
    }
    private void sendEmailToCustomer(){
        System.out.println("Email sent to the customer.");
    }

    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            CompletableFuture.supplyAsync(()->getOrder())
                    .thenAccept(productNo -> processPayment(productNo));
        }
        System.out.print("Action completed");
    }


}
