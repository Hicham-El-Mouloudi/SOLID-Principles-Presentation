package org.springformation.solid.principles.propre.adapter;

public interface InventaireRestaurantSystem {
    public void updateStock(String ingredient, int quantity);

    public void requestLowStockSupplies();
}
