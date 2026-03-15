package org.springformation.solid.principles.examples.composition_ou_heritage.sale;

public class GenerateurElectrique {
    protected double niveauCarburant;
    // ! CODE DUPLIQUÉ  
    public void injecterCarburant() {
        //
        System.out.println("Injection complexe du carburant dans le moteur...");
        this.niveauCarburant -= 0.5;
    }

    public void produireElectricite() {
        injecterCarburant();
        System.out.println("Production d'énergie en cours.");
    }
}
