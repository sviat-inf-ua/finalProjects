<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<%@include file="/WEB-INF/views/addStyle.jsp"%>

	<div id="wrapper">
		<div id="header">
			<h2>View customers</h2>
		</div>
	</div>

	<div >

		<div >

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Customer"
				onclick="window.location.href='registerUser'; return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
		<!-- 	<thead> -->
				<tr>
					<th>fname</th>
					<th>lname</th>
					<th>mname</th>
					<th>phone</th>
					<th>ssn</th>
					<th>state</th>
					<th>city</th>
					<!-- <th>Street</th> -->
					<th>apt</th>
					<th>zip</th>
					<th>height</th>
					<th>weight</th>
					<!-- <th>AnnualIncome</th> -->
					<th>allergies</th>
					<th>asma</th>
				</tr>
			<!-- 	</thead> -->

				<!-- loop over and print our doctors -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an "update" link with customer id -->
					<%-- <c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>	 --%>

					<!-- construct an "delete" link with customer id -->
					<%-- <c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					
					 --%>
					<!--  <tbody> -->
					<tr >
						<td>${tempCustomer.fname}</td>
						<td>${tempCustomer.lname}</td>
						<td>${tempCustomer.mname}</td>
						<td>${tempCustomer.phone}</td>
						<td>${tempCustomer.ssn}</td>
						<td>${tempCustomer.state}</td>
						<td>${tempCustomer.city}</td>
						<%-- <th>${tempCustomer.Street}</th> --%>
						<td>${tempCustomer.apt}</td>
						<td>${tempCustomer.zip}</td>
						<td>${tempCustomer.height}</td>
						<td>${tempCustomer.weight}</td>
						<%-- 	<th>${tempCustomer.AnnualIncome}</th> --%>
						<td>${tempCustomer.allergies}</td>
						<td>${tempCustomer.asma}</td>

						<%-- 	<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td> --%>

					</tr>
				<!-- 	</tbody> -->

				</c:forEach>

			</table>
	<p>
		<a href="${pageContext.request.contextPath}/admin">Back to admin
			home</a>
	</p>

		</div>

	</div>








</body>
</html>