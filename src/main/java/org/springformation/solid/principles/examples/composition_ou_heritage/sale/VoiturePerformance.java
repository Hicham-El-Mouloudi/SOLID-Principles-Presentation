package org.springformation.solid.principles.examples.composition_ou_heritage.sale;

public class VoiturePerformance extends Voiture {
    private boolean modeSportActive = false;

    public void setModeSport(boolean active) {
        this.modeSportActive = active;
        System.out.println("--- Mode Sport " + (active ? "ACTIVÉ" : "DÉSACTIVÉ") + " ---");
    }

    @Override
    // ! CHANGEMENT DE COMPORTEMENT STATIQUE A TRAVERS DES "if/else"
    // ! SI ON A 100 COMPORTEMENTS, ON AURA 100 "if/else"
    public void rouler() {
        if (modeSportActive) {
            // Comportement spécifique au Mode Sport
            injecterCarburant();
            injecterCarburant();
            System.out.println("VROUM ! La voiture fonce en Mode Sport.");
        } else {
            // Retour au comportement de base de la classe parente
            super.rouler();
        }
    }
}
