<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Profile</title>
</head>
<body>
	<h2>Perfil ${nomeAtor}</h2>
	<p><strong>Lista de Filmes | <a href="../">Click para criar ator</a></strong></p>
	<table border="1">
		<tr>
			<th>Filme</th>
			<th>Papel</th>
		</tr>
		<c:forEach var="atuo" items="${listAtuo}">
			<tr>
				<td>${atuo.filme}</td>
				<td>${atuo.papel}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>