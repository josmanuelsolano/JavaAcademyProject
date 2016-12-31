<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>MVC Application</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body style="font-family: sans-serif;">
	<h2 style="font-family: sans-serif;">MVC Application</h2>
	<hr>
	
	<div class="dropdown">
	  <button class="dropbtn">Options:</button>
	  <div class="dropdown-content">
	    <a href="<c:url value="users/"/>">Users</a>
	    <a href="<c:url value="carts/"/>">Carts</a>
	  </div>
	</div>
	
</body>
</html>