<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
    <div class="col-lg-12">
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover tablesorter">
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
				<c:forEach var="cart" items="${carts}">
					<c:choose>
					    <c:when test="${cart.cartDetails.status.id <= 1100}">
					       <c:set var="rowColor" scope="session" value="${'info'}"/>
					    </c:when>
					    <c:when test="${cart.cartDetails.status.id <= 1200}">
					       <c:set var="rowColor" scope="session" value="${'warning'}"/>
					    </c:when>
					    <c:when test="${cart.cartDetails.status.id <= 1300}">
					       <c:set var="rowColor" scope="session" value="${'success'}"/>
					    </c:when>
					    <c:when test="${cart.cartDetails.status.id <= 1400}">
					       <c:set var="rowColor" scope="session" value="${'danger'}"/>
					    </c:when>
					    <c:otherwise>
					        <c:set var="rowColor" scope="session" value="${'default'}"/>
					    </c:otherwise>
					</c:choose>
					<tr class="${rowColor}">
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
				</tbody>
			</table>
		</div>
	</div>
</div>