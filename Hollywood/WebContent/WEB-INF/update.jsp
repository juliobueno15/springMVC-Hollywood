<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Update</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
	<p><strong>atualizacao | <a href="read">Click para listagem</a></strong></p>
<form action="../update" method="post">
<pre>
<c:forEach var="ator" items="${listAtor}">
					
Nome:  	<input type="text" name="nome" value="${ator.nome}" />
		
Idade: 	<input type="number" name="idade" value="${ator.idade}" />
	    
Sexo:	<input type="text" name="sexo" value="${ator.sexo}" />
		
		<input type="hidden" name="nomeCadastro" value="${ator.nome}" />		    
        <input type="submit" value="Update" />	
</c:forEach>	
</pre>
</form>
${msg}
</body>
</html>