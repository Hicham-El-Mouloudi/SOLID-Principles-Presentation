package org.springformation.solid.principles.examples.composition_ou_heritage.propre.composants;

// COMPORTEMENT D'INJECTION DE CARBURANT
public class InjectionCarburant {
    protected double niveauCarburant;
    public void injecterCarburant() {
        //
        System.out.println("Injection complexe du carburant dans le moteur...");
        this.niveauCarburant -= 0.5;
        //
    }
}
