package org.springformation.solid.principles.propre.adapter.ui;

import org.springformation.solid.principles.propre.adapter.FinanceRestaurantSystem;
import org.springformation.solid.principles.propre.adapter.LegacyRestaurantSystem;

public class CashierApp {
    private FinanceRestaurantSystem system;

    public CashierApp(FinanceRestaurantSystem system) {
        this.system = system;
    }

    public void checkout(double total) {
        system.processPayment(total, "USD");

        // VIOLATION: Why does the Cashier have access to supplier requests?
        //system.requestLowStockSupplies();
    }
}
