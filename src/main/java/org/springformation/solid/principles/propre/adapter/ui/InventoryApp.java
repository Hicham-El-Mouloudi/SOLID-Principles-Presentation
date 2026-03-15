package org.springformation.solid.principles.propre.adapter.ui;

import org.springformation.solid.principles.propre.adapter.InventaireRestaurantSystem;
import org.springformation.solid.principles.propre.adapter.LegacyRestaurantSystem;

public class InventoryApp {
    private InventaireRestaurantSystem system;

    public InventoryApp(InventaireRestaurantSystem system) {
        this.system = system;
    }

    public void receiveDelivery(String item, int qty) {
        system.updateStock(item, qty);

        // VIOLATION: The Inventory Manager can see/trigger Tax Reports.
        //system.generateDailyTaxReport();
    }
}
