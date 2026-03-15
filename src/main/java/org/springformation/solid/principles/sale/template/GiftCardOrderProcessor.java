package org.springformation.solid.principles.sale.template;


public class GiftCardOrderProcessor extends OrderProcessor {
    @Override
    public void checkIngredients() {
        throw new UnsupportedOperationException("Gift Card Order Processor does not has ingredients");
    }
}
