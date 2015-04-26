package toulousemusee

import grails.util.GrailsWebUtil
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsHttpSession
import spock.lang.*

/**
 *
 */
class MuseeFavorisServiceIntegrationSpec extends Specification {

    def museeFavorisService
    GrailsHttpSession ghs

    def setup() {
        def request = GrailsWebUtil.bindMockWebRequest()
        ghs = request.session
        ghs.setAttribute("MuseeFavoris", new ArrayList<Musee>())
    }

    @Unroll
    void "test l'ajout d'un musee à la liste des favoris"() {
        given: "L'id d'un musée à ajouter à la liste des musées favoris"
        Integer idMusee = 2

        when: "On ajoute ce musée à la liste des musées favoris"
        museeFavorisService.ajoutMuseeFavoris(ghs, idMusee)

        then: "Le musée est bien ajouté à la liste des musées favoris contenu dans la session"
        List<Musee> favoris = ghs.getAttribute("MuseeFavoris")
        favoris.contains(Musee.findById(2))
    }

    @Unroll
    void "test la suppression d'un musee à la liste des favoris"() {
        given: "L'id du musée à supprimer de la liste des musées favoris"
        Integer idMusee = 4

        and: "La session en cours avec un attribut contenant un musee"
        museeFavorisService.ajoutMuseeFavoris(ghs, idMusee)

        when: "On supprime ce musée d la liste des musées favoris"
        museeFavorisService.supprimerMuseeFavoris(ghs, idMusee)

        then: "Le musée est bien supprimer de la liste des musées favoris contenu dans la session"
        List<Musee> favoris = ghs.getAttribute("MuseeFavoris")
        !favoris.contains(Musee.findById(4))
    }

    @Unroll
    void "test l'ajout d'un musee déjà présent dans la liste des favoris"() {
        given: "L'id d'un musée à ajouter à la liste des musées favoris"
        Integer idMusee = 2

        when: "On ajoute ce musée à la liste des musées favoris deux fois"
        museeFavorisService.ajoutMuseeFavoris(ghs, idMusee)
        museeFavorisService.ajoutMuseeFavoris(ghs, idMusee)

        then: "Le musée est bien ajouté sans doublon"
        List<Musee> favoris = ghs.getAttribute("MuseeFavoris")
        favoris.size() == 1
    }
}
