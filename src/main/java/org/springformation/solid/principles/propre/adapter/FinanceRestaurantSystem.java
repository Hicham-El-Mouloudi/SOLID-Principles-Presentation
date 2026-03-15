package org.springformation.solid.principles.propre.adapter;

public interface FinanceRestaurantSystem {
    public void processPayment(double amount, String currency);

    public void generateDailyTaxReport();
}
