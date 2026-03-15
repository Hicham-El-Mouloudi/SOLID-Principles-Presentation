package org.springformation.solid.principles.examples.composition_ou_heritage.propre.composants;

// IMPLEMENTATION DU COMPORTEMENT DE ROULAGE PERFORMANCE
public class RoulementPerformance implements Roulable{
    InjectionCarburant injectionCarburant;

    public RoulementPerformance(InjectionCarburant injectionCarburant) {
        this.injectionCarburant = injectionCarburant;
    }
    public void rouler() {
        // Comportement spécifique au Mode Sport
        injectionCarburant.injecterCarburant();
        injectionCarburant.injecterCarburant();
        System.out.println("VROUM ! La voiture fonce en Mode Sport.");
    }
}
