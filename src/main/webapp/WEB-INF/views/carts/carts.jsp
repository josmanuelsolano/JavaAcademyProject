<div class="row" ng-controller="CartCtrl" ng-init="getCarts()">
    <div class="col-lg-12">
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped tablesorter">
				<thead>
					<tr>
						<th>Cart Id <i class="fa fa-sort"></i></th>
						<th>Lines Amount <i class="fa fa-sort"></i></th>
						<th>Shipping Amount <i class="fa fa-sort"></i></th>
						<th>Cart Amount <i class="fa fa-sort"></i></th>
						<th>Ship To <i class="fa fa-sort"></i></th>
						<th>Status <i class="fa fa-sort"></i></th>
						<th>Created Date <i class="fa fa-sort"></i></th>
						<th>Modified Date <i class="fa fa-sort"></i></th>
						<th>Delete <i class="fa fa-sort"></i></th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="cart in carts">
						<td><a href="carts/edit/{{cart.cartKey.cartId}}" data-ng-bind="cart.cartKey.cartId"></a></td>
						<td data-ng-bind="cart.cartDetails.linesAmount | currency"></td>
						<td data-ng-bind="cart.cartDetails.shippingAmount | currency"></td>
						<td data-ng-bind="cart.cartDetails.cartAmount | currency"></td>
						<td data-ng-bind="cart.cartDetails.shipTo.name"></td>
						<td data-ng-bind="cart.cartDetails.status.description"></td>
						<td data-ng-bind="cart.audit.createDate | date:short"></td>
						<td data-ng-bind="cart.audit.updateDate | date:short"></td>
						<td>{{cart.cartDetails.status.id != 1300 ? 'Delete' : ''}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>