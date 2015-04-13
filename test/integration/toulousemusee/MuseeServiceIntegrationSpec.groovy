package toulousemusee


import spock.lang.*

/**
 *
 */
class MuseeServiceIntegrationSpec extends Specification {

    def museeService

    void "test insertion ou maj d'un musee avec un gestionnaire et une adresse"() {

        given:"un musée©"
        Musee musee = new  Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE", horairesOuverture: "9h Ã 17h .", telephone: "05 61 61 63 33", accesMetro: "Roseraie (A)", accesBus: "36, 38")

        and: "un gestionnaire"
        Gestionnaire gestionnaire = Gestionnaire.findByNom("Association")

        and: "une adresse"
        Adresse adresse = Adresse.findByRue("RUE DU JAPON")

        when: "on tente de répercuter en base la création ou la modification du musée"
        Musee resultMusee = museeService.insertOrUpdateMusee(musee, adresse, gestionnaire)

        then: "le musée resultante pointe sur le musée initale"
        resultMusee == musee

        and:"le musée résultante n'a pas d'erreur"
        !resultMusee.hasErrors()

        and:"le musée résultante a un id"
        resultMusee.id

        and:"le musée est bien presente en base"
        Musee.findById(resultMusee.id) != null

        and: "le musée a pour gestionnaire le gestionnaire passé en paramètre"
        resultMusee.gestionnaire == gestionnaire

        and: "le musée à pour adresse l'adresse passé en paramètre"
        resultMusee.adresse == adresse

        and:"le gestionnaire a dans sa liste de musée le musée passé en paramètre"
        gestionnaire.musees.contains(resultMusee)
    }

    void "test suppression d'un musée"() {

        given: "un musée existant en base"
        Musee musee = new  Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE", horairesOuverture: "9h Ã 17h .", telephone: "05 61 61 63 33", accesMetro: "Roseraie (A)", accesBus: "36, 38")
        Gestionnaire gestionnaire = Gestionnaire.findByNom("Association")
        Adresse adresse = Adresse.findByRue("RUE DU JAPON")
        museeService.insertOrUpdateMusee(musee, adresse, gestionnaire)

        when:"on tente de supprimer le musée"
        museeService.deleteMusee(musee)

        then:"le musée n'existe plus en base"
        Musee.findById(musee.id) == null

        and:"le gestionnaire n'a plus le musée dans sa liste de musées"
        !gestionnaire.musees.contains(musee)
    }
}
