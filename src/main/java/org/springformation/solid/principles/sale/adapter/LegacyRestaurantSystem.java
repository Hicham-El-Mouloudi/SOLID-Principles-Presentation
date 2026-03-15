package org.springformation.solid.principles.sale.adapter;

public class LegacyRestaurantSystem {

    // --- Financial Logic ---
    public void processPayment(double amount, String currency) {
        System.out.println("Processing " + currency + " payment of: " + amount);
    }

    public void generateDailyTaxReport() {
        System.out.println("Generating heavy tax report for the government...");
    }

    // --- Inventory Logic ---
    public void updateStock(String ingredient, int quantity) {
        System.out.println("Updating " + ingredient + " count by: " + quantity);
    }

    public void requestLowStockSupplies() {
        System.out.println("Contacting meat/vegetable suppliers for refills...");
    }
}
