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

    void "test l'ajout d'un musee à la liste des favoris"() {
        given: "L'id d'un musée à ajouter à la liste des musées favoris"
        Integer idMusee = 2

        when: "On ajoute ce musée à la liste des musées favoris"
        museeFavorisService.ajoutMuseeFavoris(ghs, idMusee)

        then: "Le musée est bien ajouté à la liste des musées favoris contenu dans la session"
        List<Musee> favoris = ghs.getAttribute("MuseeFavoris")
        favoris.contains(Musee.findById(2))
    }

    void "test la suppression d'un musee à la liste des favoris"() {
        given: "La session en cours avec un attribut contenant un musee"
        museeFavorisService.ajoutMuseeFavoris(ghs, idMusee)

        and: "L'id du musée à supprimer de la liste des musées favoris"
        Integer idMusee = 4

        when: "On supprime ce musée d la liste des musées favoris"
        museeFavorisService.supprimerMuseeFavoris(ghs, idMusee)

        then: "Le musée est bien supprimer de la liste des musées favoris contenu dans la session"
        List<Musee> favoris = ghs.getAttribute("MuseeFavoris")
        !favoris.contains(Musee.findById(4))
    }
}
