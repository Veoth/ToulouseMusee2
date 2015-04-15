package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'un musee valide"(String unAccesMetro, def _) {

        given: "un musee initialise avec des paramètres correct"
        Musee musee = new Musee(nom: "unNom", horairesOuverture: "horaires", telephone: "05050505055", accesBus: "65,85", accesMetro: unAccesMetro, adresse: Mock(Adresse), gestionnaire: Mock(Gestionnaire))

        expect: "l'adresse est valide"
        musee.validate() == true

        where:
        unAccesMetro           | _
        "Fac de pharamcie (B)" | _
        ""                     | _
        null                   | _

    }

    @Unroll
    void "test l'invalidite d'un musee non valide"(String unNom, String unHorairesOuverture, String unTelephone, String unAccesMetro, String unAccesBus, Adresse uneAdresse, Gestionnaire unGestionnaire) {

        given: "une adresse initialise avec des paramètres incorrect"
        Musee musee = new Musee(nom: unNom, horairesOuverture: unHorairesOuverture, telephone: unTelephone, accesBus: unAccesBus, accesMetro: unAccesMetro, adresse: uneAdresse, gestionnaire: unGestionnaire)

        expect: "l'adresse est invalide"
        musee.validate() == false

        where:
        unNom       | unHorairesOuverture   | unTelephone  | unAccesBus   | unAccesMetro | uneAdresse      | unGestionnaire
        null        | "fermé"               | "06569832"   | "9"          | "Roserai"    | Mock(Adresse)   | Mock(Gestionnaire)
        ""          | "fermé"               | "06569832"   | "8"          | "Roserai"    | Mock(Adresse)   | Mock(Gestionnaire)
        "Le louvre" | null                  | "06569832"   | "59"         | "Roserai"    | Mock(Adresse)   | Mock(Gestionnaire)
        "Le louvre" | ""                    | "06569832"   | "5"          | "Roserai"    | Mock(Adresse)   | Mock(Gestionnaire)
        "Le louvre" | "fermé"               | null         | "5"          | "Roserai"    | Mock(Adresse)   | Mock(Gestionnaire)
        "Le louvre" | "fermé"               | ""           | "5"          | "Roserai"    | Mock(Adresse)   | Mock(Gestionnaire)
        "Le louvre" | "fermé"               | "06569832"   | null         | "Roserai"    | Mock(Adresse)   | Mock(Gestionnaire)
        "Le louvre" | "fermé"               | "06569832"   | ""           | "Roserai"    | Mock(Adresse)   | Mock(Gestionnaire)
        "Le louvre" | "fermé"               | "06569832"   | "5"          | "Roserai"    | null            | Mock(Gestionnaire)
        "Le louvre" | "fermé"               | "06569832"   | "4"          | "Roserai"    | Mock(Adresse)   | null
    }
}
