<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Doctors</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
	<%@include file="/WEB-INF/views/addStyle.jsp"%>

	<div id="wrapper">
		<div id="header">
			<h2>View active/non active doctors</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Mobile Phone</th>
					<th>Email</th>
					<th>Password</th>
					<th>Active</th>
					<th>Activate/Deactivate</th>

				</tr>

				<!-- loop over and print our doctors -->
				<c:forEach var="tempDoctor" items="${doctors}">

					<%-- <!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/showFormForUpdate">
						<c:param name="doctorId" value="${tempDoctor.id}" />
					</c:url> --%>

					<!-- construct an "activate" link with doctor id -->
					<c:url var="doctorActivateVar" value="/doctorActivate">
						<c:param name="doctorId" value="${tempDoctor.id}" />
					</c:url>

					<!-- construct an "deactivate" link with doctor id -->
					<c:url var="doctorDeactivateVar" value="/doctorDeactivate">
						<c:param name="doctorId" value="${tempDoctor.id}" />
					</c:url>



					<%-- <!-- construct an "delete" link with customer id -->
					 <c:url var="deleteLink" value="/delete">
						<c:param name="doctorId" value="${tempDoctor.id}" />
					</c:url>	 --%>

					<tr>
						<td>${tempDoctor.firstName}</td>
						<td>${tempDoctor.lastName}</td>
						<td>${tempDoctor.cellPhone}</td>
						<td>${tempDoctor.email}</td>
						<td>${tempDoctor.password}</td>
						<td><c:choose>
								<c:when test="${tempDoctor.active == 1}">yes
						</c:when>
								<c:otherwise>
	          				  no
	         			</c:otherwise>
							</c:choose></td>

						<td>
							<!-- display the update link --> <a href="${doctorActivateVar}">doctorActivate</a>
							| <a href="${doctorDeactivateVar}">doctorDeactivate</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
	<p>
		<a href="${pageContext.request.contextPath}/admin">Back to admin
			home</a>
	</p>





</body>
</html>
