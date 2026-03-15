package org.springformation.solid.principles.propre.decorator;

public class BurgerBase implements Burger {

    @Override
    public double getPrice() {
        double basePrice = 10.0;
        //
        return basePrice;
    }
}
