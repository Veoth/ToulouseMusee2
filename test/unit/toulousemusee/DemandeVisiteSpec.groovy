package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite valide"(String unCode, Date uneDateDebutPeriode, Date uneDateFinPeriode, Date uneDateDemande, int unNbPersonnes, String unStatut) {

        given: "une demande de visite initialise avec des paramètres correct"
        DemandeVisite demandeVisite = new DemandeVisite(code: unCode, dateDebutPeriode: uneDateDebutPeriode, dateFinPeriode: uneDateFinPeriode, dateDemande: uneDateDemande, nbPersonnes: unNbPersonnes, statut: unStatut)

        expect: "l'adresse est valide"
        demandeVisite.validate() == true

        where:
        unCode  | uneDateDebutPeriode   | uneDateFinPeriode   |  uneDateDemande | unNbPersonnes | unStatut
        "7"     | new Date(2015,2,15)   | new Date(2015,2,17) |     new Date()  |      1        | "Confirmée"
        "7"     | new Date(2015,2,15)   | new Date(2015,2,17) |     new Date()  |      3        | "En cours de traitement"
        "7"     | new Date(2015,2,15)   | new Date(2015,2,17) |     new Date()  |      6        | "Refusée"

    }

    @Unroll
    void "test l'invalidite d'une demande de visite invalide"(String unCode, Date uneDateDebutPeriode, Date uneDateFinPeriode, Date uneDateDemande, int unNbPersonnes, String unStatut) {

        given: "une demande de visite initialise avec des paramètres incorrect"
        DemandeVisite demandeVisite = new DemandeVisite(code: unCode, dateDebutPeriode: uneDateDebutPeriode, dateFinPeriode: uneDateFinPeriode, dateDemande: uneDateDemande, nbPersonnes: unNbPersonnes, statut: unStatut)

        expect: "la demande de visite n'es pas valide"
        demandeVisite.validate() == false

        where:
        unCode  | uneDateDebutPeriode   | uneDateFinPeriode   |  uneDateDemande | unNbPersonnes | unStatut
        ""      | new Date(2015,2,15)   | new Date(2015,2,17) |     new Date()  |      1        | "Confirmée"
        null    | new Date(2015,2,15)   | new Date(2015,2,17) |     new Date()  |      3        | "En cours de traitement"
        "7"     | new Date(2015,2,15)   | new Date(2015,2,13) |     new Date()  |      6        | "Refusée"
        "7"     | new Date(2015,2,15)   | null                |     new Date()  |      3        | "En cours de traitement"
        "7"     | new Date(2015,2,15)   | new Date(2015,2,17) |     null        |      6        | "Refusée"
        "7"     | new Date(2015,2,15)   | new Date(2015,2,17) |     new Date()  |      0        | "En cours de traitement"
        "7"     | new Date(2015,2,15)   | new Date(2015,2,17) |     new Date()  |      7        | "Refusée"
        "7"     | new Date(2015,2,15)   | new Date(2015,2,17) |     new Date()  |      5        | "OK"

    }
}
