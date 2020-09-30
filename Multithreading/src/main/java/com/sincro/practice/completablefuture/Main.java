package com.sincro.practice.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            CompletableFuture.supplyAsync(()->OrderUtil.getOrder(new Order(new Random().nextInt(100))))
                    .thenApply(order -> OrderUtil.processPayment(order))
                    .thenApply(order -> OrderUtil.dispatchOrderToDriver(order))
                    .thenAccept(order -> OrderUtil.sendEmailToCustomer(order));

        }
        System.out.print("Order processing completed"); //nonblocking
    }
}

class Order {
    int orderNumber;
    public Order(int orderNumber){
        this.orderNumber = orderNumber;
    }

}

class OrderUtil{
    public static Order getOrder(Order order){
        System.out.println("Processing thread: "+Thread.currentThread());
        System.out.println("Order no: "+order.orderNumber+" fetched.");
        return order;
    }
    public static Order processPayment(Order order){
        System.out.println("Order no: "+order.orderNumber+" Payment processed.");
        return order;
    }
    public static Order dispatchOrderToDriver(Order order){
        System.out.println("Order no: "+order.orderNumber+" dispatched to the driver.");
        return order;
    }
    public static Order sendEmailToCustomer(Order order){
        System.out.println("Order no: "+order.orderNumber+" Email sent to the customer.");
        return order;
    }
}
