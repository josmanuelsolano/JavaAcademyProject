
	<div class="row" ng-controller="CartCtrl" ng-init="editCart()">
          <div class="col-sm-8">
              <form class="form-horizontal" role="form" action="/jpaproject/carts/update" method="POST">
                  <div class="col-sm-12">
                      <div class="col-sm-5">
                          <div class="form-group">
                            <label class="col-sm-5 control-label">Id</label>
                            <div class="col-sm-6">
                              <input class="form-control" type="text" name="id" ng-model="cart.cartKey.cartId" readonly="readonly"></input>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-sm-5 control-label">Lines Amount:*</label>
                            <div class="col-sm-6">
                              <input class="form-control" type="text" name="linesAmount" ng-model="cart.cartDetails.linesAmount" required>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-sm-5 control-label">Shipping Amount:*</label>
                            <div class="col-sm-6">
                              <input class="form-control" type="text" name="shippingAmount" ng-model="cart.cartDetails.shippingAmount" required>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-sm-5 control-label">Cart Amount</label>
                            <div class="col-sm-6">
                              <input class="form-control" type="text" name="cartAmount" ng-model="cart.cartDetails.cartAmount" required>
                            </div>
                          </div>
                      </div>
                      <div class="col-sm-6">
                          <div class="form-group">
							<label class="col-sm-5 control-label">Ship To * </label>
							<div class="col-sm-7">
							  <select class="form-control" name="shipTo" required>
								  <option ng-repeat="shipTo in shipTos" ng-value="shipTo.id" ng-selected="shipTo.id==cart.cartDetails.shipTo.id">{{shipTo.name}}</option>
							  </select>
							</div>
						  </div>
                          <div class="form-group">
							<label class="col-sm-5 control-label">Status * </label>
							<div class="col-sm-7">
							  <select class="form-control" name="status" required>
								  <option ng-repeat="status in statuses | filter:show" ng-value="status.id" data-ng-bind="status.description" ng-selected="status.id==cart.cartDetails.status.id"></option>
							  </select>
							</div>
						  </div>
                          <div class="form-group">
                            <label class="col-sm-5 control-label">Create Date</label>
                            <div class="col-sm-7">
                              <input class="form-control" type="text" name="createDate" ng-model="cart.audit.createDate | date:'yyyy-MM-dd HH:mm:ss' " readonly="readonly">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-sm-5 control-label">Update Date</label>
                            <div class="col-sm-7">
                              <input class="form-control" type="text" name="updateDate" ng-model="cart.audit.updateDate | date:'yyyy-MM-dd HH:mm:ss' " readonly="readonly">
                            </div>
                          </div>
                      </div>
                      <div class="col-sm-3 col-sm-offset-1">
                      	<button type="submit" name="update" class="btn btn-info">Update</button>
                      </div>
                  </div>    
              </form>
          </div>
        </div>
	