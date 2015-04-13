package toulousemusee



import spock.lang.*

/**
 *
 */
class LoadCSVServiceIntegrationSpec extends Specification {

    def loadCSVService

    @Unroll
    void "test chargement des musee du fichier .csv"() {

        given: "une base ne contenant aucun mus�e (et donc aucun gestionnaire ni adresse)"
        Adresse.count() == 0
        Gestionnaire.count() == 0
        Musee.count() == 0

        when: "on charge les donn�es"
        loadCSVService.loadCSV()

        then: "12 mus�es sont cr�es (et donc 12 adresse ainsi que 4 gestionnaires"
        Adresse.count() == 12
        Gestionnaire.count() == 4
        Musee.count() == 12
    }
}
