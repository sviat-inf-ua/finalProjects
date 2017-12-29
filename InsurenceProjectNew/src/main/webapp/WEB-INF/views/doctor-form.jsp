<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Save Doctor</title>
<%-- <%@include file="/WEB-INF/views/header.jsp"%>
<%@include file="/WEB-INF/views/menu.jsp"%>
 --%>
<%-- <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<style type="text/css">
input[type=number] {
	size: 10;
}
</style>  --%>
<%--  <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"> --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script type='text/javascript' src="https://rawgit.com/RobinHerbots/jquery.inputmask/3.x/dist/jquery.inputmask.bundle.js"></script>
<script src="viewJS.js"></script>
 <script type="text/javascript">
  function validatePassword() {
    	var x = document.getElementById("password").value;
    	var y = document.getElementById("passwordCommit").value;
    	if (x != y ) {
    		alert('Password confirmation does not match password entered');
    		return false;
    	}else if(x.length < 5){
    		alert('Password must be more then 5 characters');
    		return false;
    	}
    }
  </script>
</head>
<body>
	<%@include file="/WEB-INF/views/addStyle.jsp"%>
	<div id="wrapper">
		<div id="header">
			<h2>Save Doctor Page</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<form:form action="saveDoctor" onsubmit="return validatePassword()" modelAttribute="doctor" method="POST">
				<!-- need to associate this data with customer id -->
				<form:hidden path="id" />

				<table>
					<tbody>
						<tr>
							<td><input type="text" name="firstName"
								placeholder="First Name"></td>
						</tr>
						<tr>
							<td><input type="text" name="lastName"
								placeholder="Last Name "></td>
						</tr>
						<tr>
							<td><input type="text" name="cellPhone"
								placeholder="cellPhone "></td>
						</tr>
						<tr>
							<td><input type="email" name="email" placeholder="email"></td>
						</tr>
						<tr>
							<td><form:input path="password" id="password" type="password"
								placeholder="password"/></td>
						</tr>
						<tr>
							<td><form:input path="passwordCommit" id="passwordCommit" 
								type="password" placeholder="passwordCommit"/></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" name="submit"
								value="Save" class="add-button"></td>
						</tr>
					</tbody>
					</tbody>
				</table>

			</form:form>
			<p>
				<a href="${pageContext.request.contextPath}/admin">Back to admin
					home</a>
			</p>
		</div>
	</div>

</body>
</html>
