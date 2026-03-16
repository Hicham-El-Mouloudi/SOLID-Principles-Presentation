package org.springformation.solid.principles.examples.composition_ou_heritage.propre;

import org.springformation.solid.principles.examples.composition_ou_heritage.propre.composants.Injectable;
import org.springformation.solid.principles.examples.composition_ou_heritage.propre.composants.InjectionCarburant;

// COMPOSANT UTILISANT LE COMPORTEMENT D'INJECTION DE CARBURANT
public class GenerateurElectrique {
    Injectable injectionCarburant;

    // COMPOSITION : LE GENERATEUR POSSÈDE UN COMPORTEMENT D'INJECTION DE CARBURANT
    // NOTE: on a évité la duplication du code "injecterCarburant()" de la classe "Vehicule"
    public GenerateurElectrique(Injectable injectionCarburant) {
        this.injectionCarburant = injectionCarburant;
    }

    public void genererEnergie(){
        // DELEGATION: le generateur délègue le comportement d'injection de carburant à l'objet injectionCarburant
        injectionCarburant.injecterCarburant();
    }
}
