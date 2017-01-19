<div class="row" ng-controller='HomeCtrl' ng-init="getUsers()">
	<div class="col-lg-12">
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped tablesorter">
				<thead>
					<tr>
						<th>Username <i class="fa fa-sort"></i></th>
						<th>Name <i class="fa fa-sort"></i></th>
						<th>Role <i class="fa fa-sort"></i></th>
						<th>Active <i class="fa fa-sort"></i></th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="user in users">
						<td><a  href="users/edit/{{user.username}}" ng-click="userId(user.username)" data-ng-bind="user.username"></a></td>
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
