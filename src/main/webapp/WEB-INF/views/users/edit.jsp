<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
<head>
	<title>Users Update</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h3 style="color: blue; font-family: sans-serif;">Update User</h3>
	
	<form action="/ecom/users/update" method="post">
		<table style="width: 40%;">
			<tr>
				<td width="13%">Username</td>
				<td width="25%">
					<input type="text" name="username" value="${user.username}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td width="10%">Password:*</td>
				<td width="25%">
					<input type="password" name="password" value="">
				</td>
			</tr>
			<tr>
				<td>Name:*</td>
				<td>
					<input type="text" name="name" value="${user.name}">
				</td>
			</tr>
			<tr>
				<td>Role:*</td>
				<td>
					<select name="role">
						<c:forEach var="userRole" items="${userRoles}">
							<option value="${userRole.id}" <c:if test="${userRole.id==user.userRole.id}">selected</c:if>>${userRole.description}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Active:*</td>
				<td>
					<select name="active">
						<option value="S" <c:if test="${'S'==user.active}">selected</c:if>>S</option>
						<option value="N" <c:if test="${'N'==user.active}">selected</c:if>>N</option>
					</select>
				</td>
			</tr>
		</table>
		
		<br>
		<input type="submit" name="update" value="Update">
	</form>
	
	<br>
	<div>${msg}</div>
	
	<br>
	<a href="<c:url value="/users/"/>">Return to List</a>
</body>
</html>