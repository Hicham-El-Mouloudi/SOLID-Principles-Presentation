package org.springformation.solid.principles.examples;

public class CohesionLevelsExamples {
    // ------------------------------------------------
    // Cohesion forte
    // ------------------------------------------------
    static double calculerSalaireCohesionForte(double heures, double tauxHoraire) {
        if (heures < 40.0) { // salaire normal
            return heures * tauxHoraire;
        } else { // heures supplémentaires
            return (tauxHoraire * 40.0) +
                    (tauxHoraire * 2 * (heures - 40.0));
        }
    }



    // ------------------------------------------------
    // Cohesion Parasite
    // ------------------------------------------------
    static double calculerSalaireParasite(double heures, double salaireHoraire) {

        if (heures > 60.0) {
            // Afficher un message d'erreur si le temps travaillé
            // dépasse le montant maximum autorisé
            System.out.println("ATTENTION: Une permission spéciale ");
            System.out.println("est requise.\n");
        }

        if (heures < 40.0) {
            // Salaire régulier
            return heures * salaireHoraire;
        }
        else {
            // Heures supplémentaires
            return (salaireHoraire * 40.0) +
                    (salaireHoraire * 1.5 * (heures - 40.0));
        }
    }

    // ------------------------------------------------
    // Cohesion Partielle
    // ------------------------------------------------

    // Déterminer la paie d'un employé
    // ATTENTION : Appelez calculerPaieNormale() si les heures sont inférieures à 40
    static double calculerPaieHeuresSup(double heures, double salaireHoraire) {

        assert heures >= 40.0;

        return (salaireHoraire * 40.0) +
                (salaireHoraire * 1.5 * (heures - 40.0));
    }

    // Déterminer la paie d'un employé
    // ATTENTION : Appelez calculerPaieHeuresSup() si les heures sont supérieures à 40
    static double calculerPaieNormale(double heures, double salaireHoraire) {

        assert heures <= 40.0;

        return heures * salaireHoraire;
    }

    // ------------------------------------------------
    // Cohesion Faible
    // ------------------------------------------------
    // Détermine la paie d'un employé
    // Cette fonction comptabilise également la paie totale
    // ATTENTION : Appelez calculerPaieNormale() si les heures sont inférieures à 40
    static double calculerPaie(double heures, double salaireHoraire, double[] totalPaieGagnee) {
        
        // Erreur si on essaie de calculer une paie régulière ici
        assert heures >= 40.0;
        
        // Calculer la paie des heures supplémentaires
        double paie = (salaireHoraire * 40.0) + 
                    (salaireHoraire * 1.5 * (heures - 40.0));
        
        // Comptabilise la paie totale gagnée pour être rapportée ailleurs
        totalPaieGagnee[0] += paie;
        
        return paie;
    }
}
