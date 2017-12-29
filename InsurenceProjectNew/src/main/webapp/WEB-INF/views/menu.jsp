<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	

	$("#verticalButtonsOne").click(function() {
		
		$("#hiddenOne").toggle(function() {
			
			 $("#hiddenOne").css({"height": "100px", "background-color": "lightgrey"});
		});
		
	
	});
	/* $("#verticalButtonsOne").mouseout(function() {
		$("#hiddenOne").addClass("hidden");
	}); */
});
<!--

//-->
</script>
<div id="verticalNavigationLeft">
	
	<div id="head">Menu</div>
	<div class="verticalButtons" id="verticalButtonsOne">
	<c:choose>
	
	<c:when test="${menu1 != null }">
	
	
	
	<a href="${ref1 }">${menu1 }</a>
	
	</c:when>
	<c:otherwise>
	Register
	
	</c:otherwise>
	
	</c:choose>
	</div>
	<c:choose>
	<c:when test="${menu1 == null }">
	<div class="hidden verticalButtons" id="hiddenOne" >
		<ul>
			<li><a href="registerUser">Customers</a></li>
			<li><a href="showFormForAdd">Doctors</a></li>
		</ul>
	</div>
	</c:when>
	</c:choose>
	<div class="verticalButtons">
	<c:choose>
	<c:when test="${menu2 != null }">
	<a href="${ref2 }">${menu2 }</a>
	</c:when>
	<c:otherwise>
	<a href="login">Login</a>
	</c:otherwise>
	</c:choose>
	</div>
	<div class="verticalButtons">
	<c:choose>
	<c:when test="${menu3 != null }">
	<a href="${ref3}">${menu3 }</a>
	</c:when>
	</c:choose>
	</div>
	<div class="verticalButtons">
		<a href="logout">Logout</a>
	</div>
</div>