package org.springformation.solid.principles.propre.factory;

public abstract class OrderService {
    //
    private Sender notifier;
    public OrderService() {
        this.notifier = createSender();
    }


    public void completeOrder() {
        System.out.println("Order finished.");
        notifier.send("Your food is ready!");
    }

    public abstract Sender createSender();
}

interface Sender {
    public void send(String msg);
}
class EmailNotifier implements Sender {
    public void send(String msg) { System.out.println("Email: " + msg); }
}