<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table border="1" style="width: 100%;">
		<tr>
			<th width="5%">Cart Id</th>
			<th width="10%">Lines Amount</th>
			<th width="10%">Shipping Amount</th>
			<th width="10%">Cart Amount</th>
			<th width="17%">Ship To</th>
			<th width="7%">Status</th>
			<th width="15%">Created Date</th>
			<th width="15%">Modified Date</th>
			<th width="11%">Delete</th>
		</tr>
		<c:forEach var="cart" items="${carts}">
			<tr>
				<td><a href="<c:url value="/carts/edit/${cart.cartKey.cartId}"/>"><fmt:formatNumber pattern="000" value="${cart.cartKey.cartId}"/></a></td>
				<td><fmt:formatNumber pattern="$ #,##0.00" value="${cart.cartDetails.linesAmount}" /></td>
				<td><fmt:formatNumber pattern="$ #,##0.00" value="${cart.cartDetails.shippingAmount}" /></td>
				<td><fmt:formatNumber pattern="$ #,##0.00" value="${cart.cartDetails.cartAmount}" /></td>
				<td>${cart.cartDetails.shipTo.name}</td>
				<td>${cart.cartDetails.status.description}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cart.audit.createDate}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cart.audit.updateDate}" /></td>
				<td><c:if test="${cart.cartDetails.status.id != 1300}">Delete</c:if></td>
			</tr>
		</c:forEach>
	</table>