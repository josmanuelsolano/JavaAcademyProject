<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="row" ng-controller='HomeCtrl' ng-init='users()'>
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
						<td data-ng-blind="user.username"></td>
						<td data-ng-blind="user.name"></td>
						<td data-ng-blind="user.userRole.description"></td>
						<td data-ng-blind="user.active"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- /.row -->
