package org.springformation.solid.principles.propre.decorator;

public class ExtraCheeseDecorator implements Burger{
    Burger burger;

    public ExtraCheeseDecorator(Burger burger) {
        this.burger = burger;
    }

    @Override
    public double getPrice() {
        return 1.5 + burger.getPrice();
    }
}
