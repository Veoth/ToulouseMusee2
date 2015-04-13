package toulousemusee

class DemandeVisite {

    String code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    String statut

    static constraints = {
        nbPersonnes max: 6, min: 1
    }
}
