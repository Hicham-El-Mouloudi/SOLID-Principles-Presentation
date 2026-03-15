package org.springformation.solid.principles.propre.adapter;

public class InventaireAdapter implements InventaireRestaurantSystem {
    LegacyRestaurantSystem legacyRestaurantSystem;

    public InventaireAdapter(LegacyRestaurantSystem legacyRestaurantSystem) {
        this.legacyRestaurantSystem = legacyRestaurantSystem;
    }

    @Override
    public void updateStock(String ingredient, int quantity) {
        legacyRestaurantSystem.updateStock(ingredient,quantity);
    }

    @Override
    public void requestLowStockSupplies() {
        legacyRestaurantSystem.requestLowStockSupplies();
    }
}
