package org.springformation.solid.principles.sale.adapter.ui;

import org.springformation.solid.principles.sale.adapter.LegacyRestaurantSystem;

public class InventoryApp {
    private LegacyRestaurantSystem system;

    public InventoryApp(LegacyRestaurantSystem system) {
        this.system = system;
    }

    public void receiveDelivery(String item, int qty) {
        system.updateStock(item, qty);

        // VIOLATION: The Inventory Manager can see/trigger Tax Reports.
        system.generateDailyTaxReport();
    }
}
