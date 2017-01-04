<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-sm-3">
		<form role="form" action="/jpaproject/users/update" method="POST">
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					class="form-control" name="username" value="${user.username}"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="password">Password * </label> <input type="password"
					class="form-control" name="password"
					placeholder="Enter your Password" required>
			</div>
			<div class="form-group">
				<label for="name">Name * </label> <input type="text"
					class="form-control" name="name" value="${user.name}" required>
			</div>
			<div class="form-group">
				<label for="role">Role * </label>
				<div>
					<select class="form-control" name="role" required>
						<c:forEach var="userRole" items="${userRoles}">
							<option value="${userRole.userRoleId}"
								<c:if test="${userRole.userRoleId==user.userRole.userRoleId}">selected</c:if>>${userRole.description}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="active">Active * </label>
				<div>
					<select class="form-control" name="active" required>
						<option value="S" <c:if test="${'S'==user.active}">selected</c:if>>S</option>
						<option value="N" <c:if test="${'N'==user.active}">selected</c:if>>N</option>
					</select>
				</div>
			</div>
			<button type="submit" name="update" class="btn btn-info">Update</button>
		</form>
	</div>
</div>
<br>
<div>${msg}</div>