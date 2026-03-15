package org.springformation.solid.principles.propre.decorator;

public class GlutenFreeBunDecorator implements Burger {
    Burger burger;

    public GlutenFreeBunDecorator(Burger burger) {
        this.burger = burger;
    }

    @Override
    public double getPrice() {
        return 5 + burger.getPrice();
    }
}
