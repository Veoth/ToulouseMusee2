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

        /* 24 et 8 car ils sont charg�s pr�alablement via le fichier bootstrap */
        then: "12 mus�es sont cr�es (et donc 12 adresse ainsi que 4 gestionnaires"
        Adresse.count() == 24
        Gestionnaire.count() == 8
        Musee.count() == 24
    }
}
