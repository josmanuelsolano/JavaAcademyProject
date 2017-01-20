<div class="row" ng-controller='UserCtrl' ng-init="editUser()">
	<div class="col-sm-8">
		<form class="form-horizontal" role="form" action="/jpaproject/users/update" method="POST">
			<div class="col-sm-12">
				<div class="col-sm-5">
					<div class="form-group">
				<label class="col-sm-3 control-label">Username</label>
				<div class="col-sm-9">
					<input type="text"
					class="form-control" name="username" ng-model="user.username"
					readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Password* </label>
				<div class="col-sm-9">
					<input type="password"
					class="form-control" name="password" placeholder="Enter your Password"
					ng-model="password" required>
				</div> 
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Name* </label>
				<div class="col-sm-9">
					<input type="text"
					class="form-control" name="name" 
					ng-model="user.name" required>
				</div> 
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Role * </label>
				<div class="col-sm-9">
					<select class="form-control" name="role" required>
						<option ng-repeat="role in userRoles" ng-value="role.userRoleId" data-ng-bind="role.description" ng-selected="role.userRoleId==user.userRole.userRoleId"></option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Active * </label>
				<div class="col-sm-9">
					<select class="form-control" name="active" ng-model="user.active" required>
					    <option value="S" ng-selected="'S'==user.active">S</option>
					    <option value="N" ng-selected="'N'==user.active">N</option>
					</select>
				</div>
			</div>
			<button type="submit" name="update" class="btn btn-info">Update</button>
				</div>
			</div>
		</form>
	</div>
</div>