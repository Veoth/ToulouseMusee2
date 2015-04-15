package toulousemusee

import grails.util.GrailsWebUtil
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsHttpSession
import spock.lang.*

/**
 *
 */
class MuseeFavorisServiceIntegrationSpec extends Specification {

    def museeFavorisService
    GrailsHttpSession ghs = request.session

    def setUp() {
        def request = GrailsWebUtil.bindMockWebRequest()
        ghs = request.session
        ghs.setAttribute("MuseeFavoris", new ArrayList<Musee>())
    }

    void "test l'ajout d'un musee � la liste des favoris"() {
        given: "L'id d'un mus�e � ajouter � la liste des mus�es favoris"
        Integer idMusee = 2

        when: "On ajoute ce mus�e � la liste des mus�es favoris"
        museeFavorisService.ajoutMuseeFavoris(ghs, idMusee)

        then: "Le mus�e est bien ajout� � la liste des mus�es favoris contenu dans la session"
        List<Musee> favoris = ghs.getAttribute("MuseeFavoris")
        favoris.contains(Musee.findById(2))
    }

    void "test la suppression d'un musee � la liste des favoris"() {
        given: "La session en cours avec un attribut contenant un musee"
        museeFavorisService.ajoutMuseeFavoris(ghs, idMusee)

        and: "L'id du mus�e � supprimer de la liste des mus�es favoris"
        Integer idMusee = 4

        when: "On supprime ce mus�e d la liste des mus�es favoris"
        museeFavorisService.supprimerMuseeFavoris(ghs, idMusee)

        then: "Le mus�e est bien supprimer de la liste des mus�es favoris contenu dans la session"
        List<Musee> favoris = ghs.getAttribute("MuseeFavoris")
        !favoris.contains(Musee.findById(4))
    }
}
