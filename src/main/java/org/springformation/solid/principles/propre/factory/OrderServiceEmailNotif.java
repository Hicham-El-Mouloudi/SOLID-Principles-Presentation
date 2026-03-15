package org.springformation.solid.principles.propre.factory;

public class OrderServiceEmailNotif extends OrderService{
    @Override
    public Sender createSender() {
        return new EmailNotifier();
    }
}
