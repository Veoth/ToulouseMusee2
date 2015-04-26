package toulousemusee



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {

    def museeService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Musee.list(params), model:[museeInstanceCount: Musee.count()]
    }


    def doSearchMusee() {
        def museeList = museeService.searchMusee(params.nomMusee, params.codePostal, params.nomRue)
        render(view: 'index', model: [MuseeInstanceList: museeList, MuseeInstanceCount: museeList.size()])
    }
}
