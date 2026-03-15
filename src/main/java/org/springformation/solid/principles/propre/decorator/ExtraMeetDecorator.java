package org.springformation.solid.principles.propre.decorator;

public class ExtraMeetDecorator implements Burger{
    Burger burger;

    public ExtraMeetDecorator(Burger burger) {
        this.burger = burger;
    }

    @Override
    public double getPrice() {
        return 3 + burger.getPrice();
    }
}
