package org.springformation.solid.principles.examples.composition_ou_heritage.propre.composants;

// IMPLEMENTATION DU COMPORTEMENT DE ROULAGE NORMAL
public class RoulementNormal implements Roulable {
    Injectable injectionCarburant;

    public RoulementNormal(Injectable injectionCarburant) {
        this.injectionCarburant = injectionCarburant;
    }
    public void rouler() {
        injectionCarburant.injecterCarburant();
        System.out.println("La voiture roule.");
    }
}
