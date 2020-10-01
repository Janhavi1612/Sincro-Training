package com.sincro.practice.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            CompletableFuture.supplyAsync(()->OrderUtil.getOrder(new Order(new Random().nextInt(100))))
                    .thenApply(OrderUtil::processPayment)
                    .thenApply(OrderUtil::dispatchOrderToDriver)
                    .thenAccept(OrderUtil::sendEmailToCustomer);

        }
       // out.print("***Order processing completed***"); //nonblocking
    }
}

class Order {
    int orderNumber;
    Order(int orderNumber){
        this.orderNumber = orderNumber;
    }

}

class OrderUtil{
    static Order getOrder(Order order){
        out.println("Processing thread: "+Thread.currentThread());
        out.println("Order no: "+order.orderNumber+" fetched.");
        return order;
    }
    static Order processPayment(Order order){
        out.println("Order no: "+order.orderNumber+" Payment processed.");
        return order;
    }
    static Order dispatchOrderToDriver(Order order){
        out.println("Order no: "+order.orderNumber+" dispatched to the driver.");
        return order;
    }
    static void sendEmailToCustomer(Order order){
        out.println("Order no: "+order.orderNumber+" Email sent to the customer.");
    }
}
