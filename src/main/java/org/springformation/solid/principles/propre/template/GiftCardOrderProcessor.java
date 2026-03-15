package org.springformation.solid.principles.propre.template;


public class GiftCardOrderProcessor extends OrderProcessor {
    public void validateOrder() { System.out.println("Validating..."); }
    public void checkIngredients() { }
    public void calculatePrice() { System.out.println("Calculating..."); }
    public void sendToKitchen() { System.out.println("Sending to Chef..."); }
    public void notifyCustomer() { System.out.println("Notifying..."); }

    @Override
    public boolean hasIngredientsHook() {
        return false;
    }
}
