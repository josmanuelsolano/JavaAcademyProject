<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-sm-3">
		<form role="form" action="/jpaproject/users/update" method="POST">
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					class="form-control" name="username" ng-model="user.username"
					ng-init="user.username" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="password">Password * </label> <input type="password"
					class="form-control" name="password" placeholder="Enter your Password"
					ng-model="user.password" required>
			</div>
			<div class="form-group">
				<label for="name">Name * </label> <input type="text"
					class="form-control" name="name" ng-model="user.name" required>
			</div>
			<div class="form-group">
				<label for="role">Role * </label>
				<div>
					<select class="form-control" name="role" ng-model="userRole" required>
						<option ng-repeat="role in userRoles" value="role.user_role_id">{{role.description}}</option>
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
					<select class="form-control" name="active" ng-model="user.active" required>
					    <option value="">
					    <option value="S">S</option>
					    <option value="N">N</option>
					</select>
				</div>
			</div>
			<button type="submit" name="update" class="btn btn-info">Update</button>
		</form>
	</div>
</div>
<br>
<div>{{msg}}</div>