<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<form action="/jpaproject/carts/update" method="POST">
		<table style="width: 80%;">
			<tr>
				<td width="13%">Id</td>
				<td width="25%">
					<input type="text" name="id" value="${cart.cartKey.cartId}" readonly="readonly">
				</td>
				<td width="10%">Ship To:*</td>
				<td width="25%">
					<select name="shipToId">
						<option value="0">- Select -</option>
						<c:forEach var="shipTo" items="${shipTos}">
							<option value="${shipTo.id}" <c:if test="${shipTo.id==cart.cartDetails.shipTo.id}">selected</c:if>>${shipTo.name} -- ${shipTo.address}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Lines Amount:*</td>
				<td>
					<input type="text" name="linesAmount" value="${cart.cartDetails.linesAmount}">
				</td>
				<td>Status:*</td>
				<td>
					<select name="statusId">
						<option value="0">- Select -</option>
						<c:forEach var="status" items="${cartStatus}">
							<option value="${status.id}" <c:if test="${status.id==cart.cartDetails.status.id}">selected</c:if>>${status.description}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Shipping Amount:*</td>
				<td>
					<input type="text" name="shippingAmount" value="${cart.cartDetails.shippingAmount}">
				</td>
				<td>Create Date</td>
				<td>
					<input type="text" name="createDate" value="${cart.audit.createDate}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>Cart Amount</td>
				<td>
					<input type="text" name="cartAmount" value="${cart.cartDetails.cartAmount}">
				</td>
				<td>Update Date</td>
				<td>
					<input type="text" name="updateDate" value="${cart.audit.updateDate}" readonly="readonly">
				</td>
			</tr>
		</table>
		
		<br>
		<input type="submit" name="update" value="Update">
	</form>
	
	<br>
	<div>${msg}</div>