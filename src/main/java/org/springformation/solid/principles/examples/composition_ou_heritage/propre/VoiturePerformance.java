package org.springformation.solid.principles.examples.composition_ou_heritage.propre;

import org.springformation.solid.principles.examples.composition_ou_heritage.propre.composants.InjectionCarburant;
import org.springformation.solid.principles.examples.composition_ou_heritage.propre.composants.Roulable;

public class VoiturePerformance {
    Roulable roulable;

    public VoiturePerformance(Roulable roulable) {
        this.roulable = roulable;
    }

    // CHANGEMENT DU COMPORTEMENT EN RUNTIME
    // CHANGER LE COMPOSANT "roulable" = CHANGER LE COMPORTEMENT DE LA VOITURE
    // NOTE: on évite les if/else pour changer le comportement
    public void setMode(Roulable roulable) {
        this.roulable = roulable;
    }
    public void rouler() {
        roulable.rouler();
    }
}
