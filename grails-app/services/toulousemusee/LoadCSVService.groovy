package toulousemusee

import grails.transaction.Transactional

@Transactional
class LoadCSVService {
    def museeService

    Musee musee1;
    Musee musee2;
    Musee musee3;
    Musee musee4;
    Musee musee5;
    Musee musee6;
    Musee musee7;
    Musee musee8;
    Musee musee9;
    Musee musee10;
    Musee musee11;
    Musee musee12;

    Adresse adresse1;
    Adresse adresse2;
    Adresse adresse3;
    Adresse adresse4;
    Adresse adresse5;
    Adresse adresse6;
    Adresse adresse7;
    Adresse adresse8;
    Adresse adresse9;
    Adresse adresse10;
    Adresse adresse11;
    Adresse adresse12;

    Gestionnaire gestionnaire1;
    Gestionnaire gestionnaire2;
    Gestionnaire gestionnaire3;
    Gestionnaire gestionnaire4;

    def loadCSV() {
        adresse1 = new Adresse(numero: "2", rue: "RUE DES ARCHIVES", codePostal: "31500", ville: "TOULOUSE")
        adresse2 = new Adresse(numero: "5", rue: "RUE SAINT PANTALEON", codePostal: "31000", ville: "TOULOUSE")
        adresse3 = new Adresse(numero: "69", rue: "RUE PARGAMINIERES", codePostal: "31000", ville: "TOULOUSE")
        adresse4 = new Adresse(numero: "31", rue: "RUE DE LA FONDERIE", codePostal: "31000", ville: "TOULOUSE")
        adresse5 = new Adresse(numero: "", rue: "RUE MONTMORENCY", codePostal: "31200", ville: "TOULOUSE")
        adresse6 = new Adresse(numero: "2", rue: "RUE VIGUERIE", codePostal: "31300", ville: "TOULOUSE")
        adresse7 = new Adresse(numero: "21", rue: "RUE DE METZ", codePostal: "31000", ville: "TOULOUSE")
        adresse8 = new Adresse(numero: "2", rue: "RUE TRIPIERE", codePostal: "31000", ville: "TOULOUSE")
        adresse9 = new Adresse(numero: "2", rue: "RUE VIGUERIE", codePostal: "31300", ville: "TOULOUSE")
        adresse10 = new Adresse(numero: "7", rue: "RUE DU MAY", codePostal: "31100", ville: "TOULOUSE")
        adresse11 = new Adresse(numero: "", rue: "RUE DU JAPON", codePostal: "31400", ville: "TOULOUSE")
        adresse12 = new Adresse(numero: "13", rue: "RUE DE LA PLEAU", codePostal: "31100", ville: "TOULOUSE")

        adresse1.save(flush: true)
        adresse2.save(flush: true)
        adresse3.save(flush: true)
        adresse4.save(flush: true)
        adresse5.save(flush: true)
        adresse6.save(flush: true)
        adresse7.save(flush: true)
        adresse8.save(flush: true)
        adresse9.save(flush: true)
        adresse10.save(flush: true)
        adresse11.save(flush: true)
        adresse12.save(flush: true)

        gestionnaire1 = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture")
        gestionnaire2 = new Gestionnaire(nom: "Association")
        gestionnaire3 = new Gestionnaire(nom: "Autre institution publique")
        gestionnaire4 = new Gestionnaire(nom: "Structure commerciale")

        gestionnaire1.save(flush: true)
        gestionnaire2.save(flush: true)
        gestionnaire3.save(flush: true)
        gestionnaire4.save(flush: true)

        musee1 = new Musee(nom: "Archives municipales Toulouse", horairesOuverture: "Ouvert du lundi au vendredi de 9h � 17h. Fermeture de 12h � 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.", telephone: "05 61 61 63 33", accesMetro: "Roseraie (A)", accesBus: "36, 38", adresse: adresse1, gestionnaire: gestionnaire1)
        musee2 = new Musee(nom: "CMAV - centre m�ridional de l'architecture de la ville", horairesOuverture: "Ouvert du mardi au samedi de 13h à 19hfermé les dimanches, jours fériés et du 1er au 15 août", telephone: "05 61 23 30 49    ", accesBus: "ncv, 2, 10, 12, 14, 38, 78 et 80", accesMetro: "Capitole (A), Jean Jaurès (B)", adresse: adresse2, gestionnaire: gestionnaire2)
        musee3 = new Musee(nom: "Ensemble conventuel des Jacobins", horairesOuverture: "Ouvert tous les jours de 9h à 19h.", telephone: "05 61 22 21 92", accesBus: "NCV, 2, 10, 12, 14, 38, 78, 80", accesMetro: "Esquirol, Capitole (A)", adresse: adresse3, gestionnaire: gestionnaire1)
        musee4 = new Musee(nom: "Institue catholique de Toulouse - Espace mus�ographique baccrabere - salle Tolosa", horairesOuverture: "Ouvert le premier vendredi de chaque mois de 18h à 20h.", telephone: "05 61 36 81 12", accesBus: "2, 38", accesMetro: "Carmes (B)", adresse: adresse4, gestionnaire: gestionnaire3)
        musee5 = new Musee(nom: "L'aerotheque", horairesOuverture: "Ouvert le lundi et le mercredi de 14h à 17h et le mardi de 9h à 12h", telephone: "05 61 93 93 57", accesBus: "15", accesMetro: "", adresse: adresse5, gestionnaire: gestionnaire4)
        musee6 = new Musee(nom: "Mus�e de l'histoire de la m�decine de Toulouse", horairesOuverture: "Ouvert tous les jeudi et vendredi de 11h à 17h, et le dimande de 10h à 18h.Visites guidées sur demande.", telephone: "05 61 77 84 25", accesBus: "2, 10, 12, 14, 78, 80", accesMetro: "Saint-Cyprien-République, Esquirol (A)", adresse: adresse6, gestionnaire: gestionnaire2)
        musee7 = new Musee(nom: "Mus�e des augustins - mus�� des beaux arts de Toulouse", horairesOuverture: "Tous les jours : 10h - 18h /  nocturne le mercredi jusqu'à 21h.", telephone: "05 61 22 21 82", accesBus: "ncv, 2, 10, 14, 38, 78, 80", accesMetro: "Esquirol (A) ou Carmes (B)", adresse: adresse7, gestionnaire: gestionnaire1)
        musee8 = new Musee(nom: "Mus�e des compagnons", horairesOuverture: "Le Mercredi et le 1er dimanche de chaque mois de 14h à 17h", telephone: "05 62 47 41 77", accesBus: "2, 10, 12, 14, 38, 78, 80", accesMetro: "Esquirol, Capitole (A)", adresse: adresse8, gestionnaire: gestionnaire2)
        musee9 = new Musee(nom: "Mus�e des instruments de m�decine de ho�pitaux de Toulouse", horairesOuverture: "Ouvert tous les jeudi et vendredi de 13h à 17h. Ouvert le premier dimanche du mois.Visites guidées sur demande.", telephone: "05 61 77 82 72", accesBus: "2, 10, 12, 14, 78, 80", accesMetro: "Saint-Cyprien-République, Esquirol (A)", adresse: adresse9, gestionnaire: gestionnaire4)
        musee10 = new Musee(nom: "Mus�e du vieux Toulouse", horairesOuverture: "Ouvert tous les jours du 2 mai au 31 octobre de 14h00 à 18h00.Fermé le dimanche et jours fériés.", telephone: "05 62 27 11 50", accesBus: "2, 10, 12, 14, 38, 78, 80", accesMetro: "Esquirol, Capitole (A)", adresse: adresse10, gestionnaire: gestionnaire2)
        musee11 = new Musee(nom: "Mus�e George-Labit", horairesOuverture: "Musée ouvert de 10h à 17h en hiver et de 10h à 18h en été (du 1er juin au 30 septembre). Fermeture hebdomadaire le mardi.Bibliothèque ouverte le lundi de 14h à 17h, le mardi et le mercredi : 9h-12h et 14h-17h.", telephone: "05 61 14 65 50", accesBus: "10, 2, 27", accesMetro: "François Verdier (B)", adresse: adresse11, gestionnaire: gestionnaire1)
        musee12 = new Musee(nom: "Mus�e Paul Dupuy - Arts graphiques et arts d�coratifs", horairesOuverture: "Ouvert de 10h - 17h en hiver et de 10h à 18h en été (du 1er juin au 30 septembre). Fermé le mardi et jours fériés.", telephone: "05 61 14 65 50", accesBus: "ncv, 2, 12, 52", accesMetro: "Esquirol (A) Carmes (B)", adresse: adresse12, gestionnaire: gestionnaire1)

        musee1.save(flush: true)
        musee2.save(flush: true)
        musee3.save(flush: true)
        musee4.save(flush: true)
        musee5.save(flush: true)
        musee6.save(flush: true)
        musee7.save(flush: true)
        musee8.save(flush: true)
        musee9.save(flush: true)
        musee10.save(flush: true)
        musee11.save(flush: true)
        musee12.save(flush: true)

        museeService.insertOrUpdateMusee(musee1, adresse1, gestionnaire1)
        museeService.insertOrUpdateMusee(musee2, adresse2, gestionnaire2)
        museeService.insertOrUpdateMusee(musee3, adresse3, gestionnaire1)
        museeService.insertOrUpdateMusee(musee4, adresse4, gestionnaire3)
        museeService.insertOrUpdateMusee(musee5, adresse5, gestionnaire4)
        museeService.insertOrUpdateMusee(musee6, adresse6, gestionnaire2)
        museeService.insertOrUpdateMusee(musee7, adresse7, gestionnaire1)
        museeService.insertOrUpdateMusee(musee8, adresse8, gestionnaire2)
        museeService.insertOrUpdateMusee(musee9, adresse9, gestionnaire4)
        museeService.insertOrUpdateMusee(musee10, adresse10, gestionnaire2)
        museeService.insertOrUpdateMusee(musee11, adresse11, gestionnaire1)
        museeService.insertOrUpdateMusee(musee12, adresse12, gestionnaire1)

    }
}
