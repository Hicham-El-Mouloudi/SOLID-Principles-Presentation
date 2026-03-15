package org.springformation.solid.principles.sale.factory;

public class OrderService {
    //
    private EmailNotifier notifier = new EmailNotifier();

    public void completeOrder() {
        System.out.println("Order finished.");
        notifier.sendEmail("Your food is ready!");
    }
}

class EmailNotifier {
    public void sendEmail(String msg) { System.out.println("Email: " + msg); }
}