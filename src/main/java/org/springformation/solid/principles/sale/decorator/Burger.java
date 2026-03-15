package org.springformation.solid.principles.sale.decorator;

public class Burger {
    public boolean extraCheese;
    public boolean extraMeat;
    public boolean glutenFreeBun;

    public double getPrice() {
        double basePrice = 10.0;
        //
        if (extraCheese) basePrice += 1.5;
        if (extraMeat) basePrice += 2.0;
        if (glutenFreeBun) basePrice += 2.5;
        return basePrice;
    }
}
