package org.springformation.solid.principles.propre.template;

public abstract class OrderProcessor {
    //
    public final void runPipeline(String orderType) {
        validateOrder();
        if (hasIngredientsHook()) {
            checkIngredients(); // <--- CRASH POINT
        }
        calculatePrice();
        sendToKitchen();
        notifyCustomer();
    }

    public abstract void validateOrder();
    public abstract void checkIngredients();
    public abstract void calculatePrice();
    public abstract void sendToKitchen();
    public abstract void notifyCustomer();

    public boolean hasIngredientsHook() {
        return true;
    }
}
