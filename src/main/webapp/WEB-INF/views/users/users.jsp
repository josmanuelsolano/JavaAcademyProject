<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="row">
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
				<c:forEach var="user" items="${users}">
					<tr ng-repeat="user in users">
						<td data-ng-blind="user.username"><a href="<c:url value="/users/edit/${user.username}"/>">${user.username}</a></td>
						<td data-ng-blind="user.name">${user.name}</td>
						<td data-ng-blind="user.userRole.description">${user.userRole.description}</td>
						<td data-ng-blind="user.active">${user.active}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- /.row -->
