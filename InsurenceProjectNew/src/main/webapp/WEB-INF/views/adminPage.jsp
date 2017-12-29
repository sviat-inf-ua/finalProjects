<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Admin Page Doctors</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<h2>Welcome to Admin Page</h2>
<%@include file="/WEB-INF/views/addStyle.jsp"%>
<div id="container">


	
	 	<div id="content">
		
			<!-- put new button: Add Customer -->
		
		<table class="admintable">
				<tr>
					<th>
			<input type="button" value="Add Doctor"onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"/>
				   </th>
				   <th><input type="button" value="view Doctors"onclick="window.location.href='listDoctors'; return false;"
				   class="add-button"/></th>
			<!-- </tr> -->
			<!-- <tr> -->
			<th>	   
			<input type="button" value="Add Location"onclick="window.location.href='showLocationForm'; return false;"
				   class="add-button"/></th>
				   
				   <th>
		<input type="button" value="view Locations"onclick="window.location.href='listLocations'; return false;"
				   class="add-button"/></th>
				   
				   
				   <th>
				   <input type="button" value="Add Doctor Type"onclick="window.location.href='showDoctorTypeForm'; return false;"
				   class="add-button"/></th>
				   <th>
				   <input type="button" value="view Doctor Types"onclick="window.location.href='listDoctorTypes'; return false;"
				   class="add-button"/></th>
				   <th>
				   <input type="button" value="Create Plan"onclick="window.location.href='showInsurancePlanForm'; return false;"
				   class="add-button"/></th>
				   <th>
				   <input type="button" value="Create Benefit"onclick="window.location.href='showBenefitsForm'; return false;"
				   class="add-button"/></th>
				   
				   <th>
				   <input type="button" value="add Benefit to plan"onclick="window.location.href='showPlanBenefitForm'; return false;"
				   class="add-button"/></th>
				   
				     <th>
				   <input type="button" value="view Customers"onclick="window.location.href='listCustomers'; return false;"
				   class="add-button"/></th>
				   
				   
						   
		<th><input type="button" value="Active Doctors"onclick="window.location.href='listActiveDoctors'; return false;"
				   class="add-button"/>
		<input type="button" value="Non Active Doctors"onclick="window.location.href='listNonActiveDoctors'; return false;"
				   class="add-button"/>		</th>   
				   
				   
				   <!-- </th>
		
		<a href="listNonActiveDoctors" style="color:red">Non active Doctors</a></th> -->
		<!-- <th>
		<a href="listActiveDoctors"style="color:red">Non active Doctors</a></th> -->
		
		</tr>
		</table>
		
				   <input type="button" value="Log Out"onclick="window.location.href='logout'; return false;"
				   class="add-button"/>
		
			
		</div> 
	
	</div>

</body>
</html>