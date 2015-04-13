package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisiteMusee)
class DemandeVisiteMuseeSpec extends Specification {

    @Unroll
    void "test la validité d'une demande de visite de musee valide" () {
        given: "Une demande de visite de musee avec des paramètres correct"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(museeAVisite: unMusee, demandeVisite: uneDemandeViste, dateVisite: uneDate)

        expect: "Une demande de visite de musee valide"
        demandeVisiteMusee.validate() == true

        where:
        uneDate    | unMusee     | uneDemandeViste
        new Date() | Mock(Musee) | Mock(DemandeVisite)

    }

    @Unroll
    void "test l'invalidité d'une demande de visite de musee non valide" () {
        given: "Une demande de visite de musee avec des paramètres incorrect"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(museeAVisite: unMusee, demandeVisite: uneDemandeViste, dateVisite: uneDate)

        expect: "Une demande de visite de musee invalide"
        demandeVisiteMusee.validate() == false

        where:
        uneDate    | unMusee     | uneDemandeViste
        null       | Mock(Musee) | Mock(DemandeVisite)
        new Date() | null        | Mock(DemandeVisite)
        new Date() | Mock(Musee) | null

    }
}
