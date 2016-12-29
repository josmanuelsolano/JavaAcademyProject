<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>MVC Application</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h2 style="font-family: sans-serif;">MVC Application</h2>
	<hr>
	<h3>Option:</h3>
	<ul>
		<li>--------------------------------------------</li>
		<li><a href="<c:url value="users/"/>">Users</a></li>
		<li>--------------------------------------------</li>
		<li><a href="<c:url value="carts/"/>">Carts</a></li>
		
	</ul>
</body>
</html>