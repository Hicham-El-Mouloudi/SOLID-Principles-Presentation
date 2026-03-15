package org.springformation.solid.principles.sale.template;

public abstract class OrderProcessor {
    //
    public final void runPipeline(String orderType) {
        validateOrder();
        checkIngredients(); // <--- CRASH POINT
        calculatePrice();
        sendToKitchen();
        notifyCustomer();
    }

    public void validateOrder() { System.out.println("Validating..."); }
    public void checkIngredients() { }
    public void calculatePrice() { System.out.println("Calculating..."); }
    public void sendToKitchen() { System.out.println("Sending to Chef..."); }
    public void notifyCustomer() { System.out.println("Notifying..."); }
}
