package toulousemusee

class DemandeVisite {

    String code
    Date dateDebutPeriode
    Date dateFinPeriode
    Date dateDemande
    int nbPersonnes
    String statut

    static hasMany = [
            musees: Musee
    ]

    static belongsTo = Musee

    static constraints = {
        code blank: false
        nbPersonnes max: 6, min: 1
        statut inList:["En cours de traitement", "Confirmée", "Refusée"]
        dateFinPeriode validator: {fin, objet ->
                                   fin?.after(objet.dateDebutPeriode) }
        }
    }

