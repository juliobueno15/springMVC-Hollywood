<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Read</title>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <link href="//fonts.googleapis.com/css?family=Lobster&subset=latin,latin-ext" rel="stylesheet" type="text/css">
        <title>Actors</title>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

        <link rel="stylesheet" href="{% static 'css/blog.css' %}">



        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
</head>
<body>
	<link rel="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js">
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
	<p><strong>Lsta de atores | <a href="./">Click para criar ator</a></strong></p>
	<table border="1" id="myTable" class="table table-striped table-bordered table-hover">
		<tr>
			<th>Nome</th>
			<th>Idade</th>
			<th>Sexo</th>
		</tr>
		<c:forEach var="ator" items="${listAtor}">
			<tr>
				<td>${ator.nome}</td>
				<td>${ator.idade}</td>
				<td>${ator.sexo}</td>
				<td><a href="update/<c:out value='${ator.nome}'/>">Update</a></td>
				<td><a href="delete/<c:out value='${ator.nome}'/>">Delete</a></td>
				<td><a href="profile/<c:out value='${ator.nome}'/>">profile</a></td>
			</tr>
		</c:forEach>
	</table>
	    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>

        <script>
        $(document).ready( function () {
            $('#myTable').DataTable();
        } );
        </script>
	
</body>
</html>