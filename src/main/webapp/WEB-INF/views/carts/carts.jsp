<div class="row" ng-controller="CartCtrl" ng-init="getCarts()">
    <div class="col-lg-12">
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped tablesorter">
				<thead>
					<tr>
						<th>Cart Id </th>
						<th>Lines Amount </th>
						<th>Shipping Amount </th>
						<th>Cart Amount </th>
						<th>Ship To </th>
						<th>Status </th>
						<th>Created Date </th>
						<th>Modified Date </th>
						<th>Delete </th>
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
						<td data-ng-bind="cart.audit.createDate | date:'yyyy-MM-dd HH:mm:ss'"></td>
						<td data-ng-bind="cart.audit.updateDate | date:'yyyy-MM-dd HH:mm:ss'"></td>
						<td data-ng-bind="cart.cartDetails.status.id != 1300 ? 'Delete' : ''"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>