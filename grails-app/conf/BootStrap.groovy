class BootStrap {

    def loadCSVService

    def init = { servletContext ->
        loadCSVService.loadCSV();
    }
    def destroy = {
    }
}
