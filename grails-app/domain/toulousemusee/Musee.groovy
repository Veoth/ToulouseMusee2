package toulousemusee

class Musee {

    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus

    Adresse adresse

    Gestionnaire gestionnaire

    static hasMany = [
            demandeVisites: DemandeVisite
    ]

    static constraints = {
        nom blank: false
        horairesOuverture blank: false
        telephone blank: false
        accesBus blank: false
        accesMetro nullable: true
    }

    static mapping = {
        gestionnaire fetch: 'join'
        adresse fetch:  'join'
    }
}
