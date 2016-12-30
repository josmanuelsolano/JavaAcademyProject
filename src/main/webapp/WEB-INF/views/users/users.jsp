<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
	<title>Users</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h2 style="font-family: sans-serif;">MVC Application</h2>
	<hr>
	<h3>Users:</h3>
	<br>
	<table border="1" style="width: 50%;">
		<tr>
			<th width="20%">Username</th>
			<th width="10%">name</th>
			<th width="10%">Role</th>
			<th width="10%">Active</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><a href="<c:url value="/users/edit/${user.username}"/>">${user.username}</a></td>
				<td>${user.name}</td>
				<td>${user.userRole.description}</td>
				<td>${user.active}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value="/"/>">Return to Menu</a>
	
</body>
</html>