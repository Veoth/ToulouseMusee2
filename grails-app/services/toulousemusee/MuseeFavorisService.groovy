package toulousemusee

import grails.transaction.Transactional

import javax.servlet.http.HttpSession

@Transactional
class MuseeFavorisService {


    def serviceMethod() {

    }

    def ajoutMuseeFavoris(HttpSession session, Integer idMusee) {
        List<Musee> favoris = session.getAttribute("MuseeFavoris") as List<Musee>
        Boolean exist = false

        /* Si le musée est déjà dans les musées favoris, on ne l'ajout pas */
        for (Integer id : favoris.id) {
            if (id == idMusee) {
                exist = true
            }
        }

        if (!exist) {
            favoris.add(Musee.findById(idMusee))
            session.setAttribute("MuseeFavoris", favoris)
        }
    }

    def supprimerMuseeFavoris(HttpSession session, Integer idMusee) {
        List<Musee> favoris = session.getAttribute("MuseeFavoris") as List<Musee>

        if (favoris != null && favoris?.size() != 0) {
            for (Musee m : favoris) {
                if (m.id == idMusee) {
                    favoris.remove(m)
                    break
                }
            }

            session.setAttribute("MuseeFavoris", favoris)
        }
    }
}
