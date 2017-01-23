<div class="row" ng-controller='UserCtrl' ng-init="getUsers()">
	<div class="col-sm-3">
		<form class="form" role="search">
			<div class="input-group">
				<input class="form-control" id="srchInput" name="srchInput"
					type="text" placeholder="Search" ng-model="srchInput">
				<div class="input-group-btn" ng-click="searchInput(srchInput)">
					<button class="btn btn-default" type="submit">
						<i">search</i>
					</button>
				</div>
			</div>
		</form>
	</div>
	<div class="col-lg-12">
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped tablesorter">
				<thead>
					<tr>
						<th>Username</th>
						<th>Name</th>
						<th>Role</th>
						<th>Active</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="user in users">
						<td><a href="users/edit/{{user.username}}"
							data-ng-bind="user.username"></a></td>
						<td data-ng-bind="user.name"></td>
						<td data-ng-bind="user.userRole.description"></td>
						<td data-ng-bind="user.active"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- /.row -->
