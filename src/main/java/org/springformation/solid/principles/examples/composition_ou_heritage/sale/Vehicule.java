package org.springformation.solid.principles.examples.composition_ou_heritage.sale;

public abstract class Vehicule {
    protected double niveauCarburant;

    public void injecterCarburant() {
        //
        System.out.println("Injection complexe du carburant dans le moteur...");
        this.niveauCarburant -= 0.5;
    }
}
