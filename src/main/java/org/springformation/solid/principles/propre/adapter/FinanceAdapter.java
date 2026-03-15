package org.springformation.solid.principles.propre.adapter;

public class FinanceAdapter implements FinanceRestaurantSystem{
    LegacyRestaurantSystem legacyRestaurantSystem;

    public FinanceAdapter(LegacyRestaurantSystem legacyRestaurantSystem) {
        this.legacyRestaurantSystem = legacyRestaurantSystem;
    }

    @Override
    public void processPayment(double amount, String currency) {
        legacyRestaurantSystem.processPayment(amount,currency);
    }

    @Override
    public void generateDailyTaxReport() {
        legacyRestaurantSystem.generateDailyTaxReport();
    }
}
