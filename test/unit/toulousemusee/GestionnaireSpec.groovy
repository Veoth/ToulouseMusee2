package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gestionnaire)
class GestionnaireSpec extends Specification {

    @Unroll
    void "test la validite d'un gestionnaire valide"(String unNom, def _) {

        given: "un gestionnaire initialise avec des param�tres correct"
        Gestionnaire gestionnaire = new Gestionnaire(nom: unNom)

        expect: "le gestionnaire est valide"
        gestionnaire.validate() == true

        where:
        unNom     | _
        "Charles" | _

    }

    @Unroll
    void "test toString gestionnaire"() {

        given: "un gestionnaire initialise avec des param�tres correct"
        Gestionnaire gestionnaire = new Gestionnaire(nom: "Charles")

        expect: "l'adresse est valide"
        gestionnaire.toString() == "Charles"
    }

    @Unroll
    void "test l'invalidite d'un gestionnaire non valide"(String unNom, def _) {

        given: "un gestionnaire initialise avec des param�tres incorrect"
        Gestionnaire gestionnaire = new Gestionnaire(nom: unNom)

        expect: "le gestionnaire n'est pas valide"
        gestionnaire.validate() == false

        where:
        unNom | _
        null  | _
        ""    | _

    }
}
