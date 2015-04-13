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
    void "test la validite d'une demande de visite valide"(String unCode, Date uneDateDebutPeriode, Date uneDateFinPeriode, int unNbPersonnes, String unStatut) {

        given: "une demande de visite initialise avec des paramètres correct"
        DemandeVisite demandeVisite = new DemandeVisite(code: unCode, dateDebutPeriode: uneDateDebutPeriode, dateFinPeriode: uneDateFinPeriode, nbPersonnes: unNbPersonnes, statut: unStatut)

        expect: "l'adresse est valide"
        demandeVisite.validate() == true

        where:
        unCode  | uneDateDebutPeriode   | uneDateFinPeriode | unNbPersonnes | unStatut
        "7"     | new Date()            | new Date()        | 1             | "Ok"
        "7"     | new Date()            | new Date()        | 6             | "En attente"

    }

    @Unroll
    void "test l'invalidite d'une demande de visite invalide"(String unCode, Date uneDateDebutPeriode, Date uneDateFinPeriode, int unNbPersonnes, String unStatut) {

        given: "une demande de visite initialise avec des paramètres incorrect"
        DemandeVisite demandeVisite = new DemandeVisite(code: unCode, dateDebutPeriode: uneDateDebutPeriode, dateFinPeriode: uneDateFinPeriode, nbPersonnes: unNbPersonnes, statut: unStatut)

        expect: "la demande de visite n'es pas valide"
        demandeVisite.validate() == false

        where:
        unCode  | uneDateDebutPeriode   | uneDateFinPeriode | unNbPersonnes | unStatut
        null    | new Date()            | new Date()        | 1             | "Ok"
        "7"     | null                  | new Date()        | 6             | "En attente"
        "7"     | new Date()            | null              | 1             | "Ok"
        "7"     | new Date()            | new Date()        | 1             | null
        "7"     | new Date()            | new Date()        | 7             | "En attente"
        "7"     | new Date()            | new Date()        | -2            | "Ok"

    }
}
