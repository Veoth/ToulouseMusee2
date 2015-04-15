package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {

    @Unroll
    void "test la validite d'une adresse valide"(String uneRue, String uneVille, String unCP, String unNumero) {

        given: "une adresse initialise avec des paramètres correct"
        Adresse adresse = new Adresse(rue: uneRue, ville: uneVille, codePostal: unCP, numero: unNumero)

        expect: "l'adresse est valide"
        adresse.validate() == true

        where:
        uneRue             | uneVille   | unCP      | unNumero
        "rue des archives" | "Toulouse" | "31100"   | "19"
        "rue des archives" | "Lyon"     | "69000"   | ""
        "rue des archives" | "Toulouse" | "31100"   | null

    }

    @Unroll
    void "test l'invalidite d'une adresse non valide"(String uneRue, String uneVille, String unCP, String unNumero) {

        given: "une adresse initialise avec des paramètres incorrect"
        Adresse adresse = new Adresse(rue: uneRue, ville: uneVille, codePostal: unCP, numero: unNumero)

        expect: "l'adresse est invalide"
        adresse.validate() == false

        where:
        uneRue             | uneVille   | unCP      | unNumero
        null               | "Toulouse" | "31100"   | "9"
        ""                 | "Toulouse" | "31100"   | "8"
        "rue des archives" | null       | "31100"   | "59"
        "rue des archives" | ""         | "31100"   | "5"
        "rue des archives" | "Toulouse" | null      | "5"
        "rue des archives" | "Toulouse" | ""        | "5"
    }
}
