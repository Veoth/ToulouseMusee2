package toulousemusee

class Adresse {

    String numero
    String rue
    String codePostal
    String ville

    String toString() {

        String res =  (numero ?: "") + " " + rue + " " + codePostal + " " + ville
        return res
    }

    static constraints = {
        rue blank:false
        codePostal blank:false
        ville blank:false
        numero nullable: true
    }
}
