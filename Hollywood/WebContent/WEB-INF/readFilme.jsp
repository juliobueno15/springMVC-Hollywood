<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ReadFileme</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
	<p><strong>Lsta de Filmes | <a href="create.jsp">Click para criar ator</a></strong></p>
	<table border="1">
		<tr>
			<th>Titulo</th>
			<th>Ano</th>
			<th>Categoria</th>
		</tr>
		<c:forEach var="filme" items="${listFilme}">
			<tr>
				<td>${filme.titulo}</td>
				<td>${filme.ano}</td>
				<td>${filme.categoria}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>