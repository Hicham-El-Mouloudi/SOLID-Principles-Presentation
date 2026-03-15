package org.springformation.solid.principles.sale.adapter.ui;

import org.springformation.solid.principles.sale.adapter.LegacyRestaurantSystem;

public class CashierApp {
    private LegacyRestaurantSystem system;

    public CashierApp(LegacyRestaurantSystem system) {
        this.system = system;
    }

    public void checkout(double total) {
        system.processPayment(total, "USD");

        // VIOLATION: Why does the Cashier have access to supplier requests?
        system.requestLowStockSupplies();
    }
}
