package toulousemusee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    def serviceMethod() {

    }

    List<Musee> searchMusee(String inNomMusee, String codePostal, String inNomRue) {
            def criteria = Musee.createCriteria()

            List<Musee> res = criteria.list {

                if (inNomMusee) {
                    like 'nom', "%${inNomMusee}%"
                }

                if (inNomRue) {
                    adresse {
                        like 'rue', "%${inNomRue}%"
                    }
                }

                if (codePostal) {
                    adresse {
                        like 'codePostal', "${codePostal}"
                    }
                }
            }

        res
    }

    Musee insertOrUpdateMusee(Musee musee, Adresse adresse, Gestionnaire gestionnaire) {
        def gest = gestionnaire

        musee.adresse = adresse
        musee.gestionnaire = gestionnaire
        musee.save(flush: true)

        gest.addToMusees(musee)
        gest.save()

        musee
    }

    def deleteMusee(Musee musee) {
        def gestionnaire = musee.gestionnaire

        gestionnaire.removeFromMusees(musee)

        musee.delete()
        gestionnaire.save(flush: true)
    }
}
