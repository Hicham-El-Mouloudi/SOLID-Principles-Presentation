package org.springformation.solid.principles.examples.composition_ou_heritage.sale;

public class Voiture extends Vehicule {
    public void rouler() {
        // ! REUTILISATION DU CODE "injecterCarburant()" DE LA CLASSE "Vehicule"
        injecterCarburant();
        System.out.println("La voiture roule.");
    }
}
