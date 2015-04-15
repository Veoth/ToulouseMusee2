<%@ page import="toulousemusee.Musee; toulousemusee.Adresse" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 18em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}
			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}
			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
			#status li {
				line-height: 1.3;
			}
			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}
			#page-body {
				margin: 2em 1em 1.25em 18em;
			}
			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}
			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}
			#controller-list ul {
				list-style-position: inside;
			}
			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}
			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}
				#page-body {
					margin: 0 1em 1em;
				}
				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>


    <g:form>
        <label for="inNomMusee">Nom (ou partie) du musée : </label>
        <g:textField name="inNomMusee"/><br/>

        <label for="codePostal">Code postal du musée : </label>
        <g:select name="codePostal" from="${Adresse.list().codePostal.unique()+ ""}" /><br/>

        <label for="inNomRue">Nom (ou partie) de la rue du musée : </label>
        <g:textField name="inNomRue"/><br/>

        <g:actionSubmit value="Rechercher" action="doSearchMusee"/>
    </g:form>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />

            <g:sortableColumn property="horairesOuverture" title="${message(code: 'musee.horairesOuverture.label', default: 'Horaires Ouverture')}" />

            <g:sortableColumn property="telephone" title="${message(code: 'musee.telephone.label', default: 'Telephone')}" />

            <g:sortableColumn property="accesBus" title="${message(code: 'musee.accesBus.label', default: 'Acces Bus')}" />

            <g:sortableColumn property="accesMetro" title="${message(code: 'musee.accesMetro.label', default: 'Acces Metro')}" />

            <th><g:message code="musee.adresse.label" default="Adresse" /></th>

            <th><g:message code="musee.gestionnaire.label" default="Gestionnaire" /></th>

			<th>Ajout favoris</th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${museeInstanceList}" status="i" var="museeInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "nom")}</g:link></td>

                <td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>

                <td>${fieldValue(bean: museeInstance, field: "telephone")}</td>

                <td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>

                <td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>

                <td>${fieldValue(bean: museeInstance, field: "adresse")}</td>

                <td>${fieldValue(bean: museeInstance, field: "gestionnaire")}</td>

				<td>
					<a  class="myButton" href="${createLink(controller: "index",action: "addMuseeToFavoris",params: [museeToAdd: museeInstance.id])}"> Ajouter à ma liste</a>
				</td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${museeInstanceCount ?: 0}" max="5" />
    </div>
</body>
</html>