package toulousemusee

class IndexController {

    MuseeFavorisService museeFavorisService
    def museeService

    def index() {
        if (!session.getAttribute("MuseeFavoris")) {
            session.setAttribute("MuseeFavoris", new ArrayList<Musee>())
        }

        System.out.println(params.offset)
        [museeFavoris: session.getAttribute("MuseeFavoris") as List<Musee>]
    }

    def doSearchMusee() {
        int offset = params.int("offset") ?: 0;
        def museeList = museeService.searchMusee(params.inNomMusee, params.codePostal, params.inNomRue, 5, offset)
        params.max = 5
        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size(), museeFavoris: session.getAttribute("MuseeFavoris")  as List<Musee>], params: params)
    }

    def addMuseeToFavoris() {
        Integer museeId = params.museeToAdd as Integer
        museeFavorisService.ajoutMuseeFavoris(session, museeId)
        render(view: 'index', model: [museeFavoris: session.getAttribute("MuseeFavoris")  as List<Musee>])
    }

    def suppMuseeToFavoris() {
        Integer museeId = params.museeToSupp as Integer
        museeFavorisService.supprimerMuseeFavoris(session, museeId)
        render(view: 'index', model: [museeFavoris: session.getAttribute("MuseeFavoris")  as List<Musee>])
    }
}
