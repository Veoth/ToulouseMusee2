package toulousemusee


import spock.lang.*

/**
 *
 */
class MuseeServiceIntegrationSpec extends Specification {

    def museeService

    void "test insertion ou maj d'un musee avec un gestionnaire et une adresse"() {

        given:"un mus�e�"
        Musee musee = new  Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE", horairesOuverture: "9h � 17h .", telephone: "05 61 61 63 33", accesMetro: "Roseraie (A)", accesBus: "36, 38")

        and: "un gestionnaire"
        Gestionnaire gestionnaire = Gestionnaire.findByNom("Association")

        and: "une adresse"
        Adresse adresse = Adresse.findByRue("RUE DU JAPON")

        when: "on tente de r�percuter en base la cr�ation ou la modification du mus�e"
        Musee resultMusee = museeService.insertOrUpdateMusee(musee, adresse, gestionnaire)

        then: "le mus�e resultante pointe sur le mus�e initale"
        resultMusee == musee

        and:"le mus�e r�sultante n'a pas d'erreur"
        !resultMusee.hasErrors()

        and:"le mus�e r�sultante a un id"
        resultMusee.id

        and:"le mus�e est bien presente en base"
        Musee.findById(resultMusee.id) != null

        and: "le mus�e a pour gestionnaire le gestionnaire pass� en param�tre"
        resultMusee.gestionnaire == gestionnaire

        and: "le mus�e � pour adresse l'adresse pass� en param�tre"
        resultMusee.adresse == adresse

        and:"le gestionnaire a dans sa liste de mus�e le mus�e pass� en param�tre"
        gestionnaire.musees.contains(resultMusee)
    }

    void "test suppression d'un mus�e"() {

        given: "un mus�e existant en base"
        Musee musee = new  Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE", horairesOuverture: "9h � 17h .", telephone: "05 61 61 63 33", accesMetro: "Roseraie (A)", accesBus: "36, 38")
        Gestionnaire gestionnaire = Gestionnaire.findByNom("Association")
        Adresse adresse = Adresse.findByRue("RUE DU JAPON")
        museeService.insertOrUpdateMusee(musee, adresse, gestionnaire)

        when:"on tente de supprimer le mus�e"
        museeService.deleteMusee(musee)

        then:"le mus�e n'existe plus en base"
        Musee.findById(musee.id) == null

        and:"le gestionnaire n'a plus le mus�e dans sa liste de mus�es"
        !gestionnaire.musees.contains(musee)
    }
}
