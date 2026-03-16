package org.springformation.solid.principles.examples.composition_ou_heritage.propre;

import org.springformation.solid.principles.examples.composition_ou_heritage.propre.composants.Injectable;
import org.springformation.solid.principles.examples.composition_ou_heritage.propre.composants.InjectionCarburant;

public class Voiture {
    Injectable injectionCarburant;

    // COMPOSITION : LA VOITURE POSSÈDE UN COMPORTEMENT D'INJECTION DE CARBURANT
    // Utilisation de "L'injection des dépendances"
    public Voiture(Injectable injectionCarburant) {
        this.injectionCarburant = injectionCarburant;
    }
    public void rouler() {
        // DELEGATION: la voiture délègue le comportement d'injection de carburant à l'objet injectionCarburant
        injectionCarburant.injecterCarburant();
        System.out.println("La voiture roule.");
    }
}
