
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Health Insurance</title>
<meta name="description"
	content="An interactive getting started guide for Brackets.">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="mainJavaScript.js"></script>
</head>
</body>
<%@include file="/WEB-INF/views/header.jsp"%>
<%@include file="/WEB-INF/views/menu.jsp"%>
<div
	style="position: relative; top: 150px; left: 400px; overflow-x: hidden; width: 700px; text-align: center; height:1000px">

	<section class="content "> <section class="main single">
	<article class="page">
	<h2 class="entry-title">Contact Us</h2>
	<div role="form" class="wpcf7" id="wpcf7-f8-p3234-o1" lang="en-US"
		dir="ltr">
		<div class="screen-reader-response"></div>
		<form action="/contact/#wpcf7-f8-p3234-o1" method="post"
			class="wpcf7-form" novalidate="novalidate">
			<div style="display: none;">
				<input type="hidden" name="_wpcf7" value="8" class="input"> <input
					type="hidden" name="_wpcf7_version" value="4.7"> <input
					type="hidden" name="_wpcf7_locale" value="en_US"> <input
					type="hidden" name="_wpcf7_unit_tag" value="wpcf7-f8-p3234-o1">
				<input type="hidden" name="_wpnonce" value="e86ff001a7">
			</div>
			<p>
				<span class="wpcf7-form-control-wrap your-message"><textarea
						name="your-message" rows="10" cols="50"
						placeholder="My Question Is..." class="input"></textarea></span>
			</p>
			<p>
				<span class="wpcf7-form-control-wrap first-name" ><input class="input"
					type="text" name="first-name" value="" size="40"
					wpcf7-text wpcf7-validates-as-required"
					aria-required="true" aria-invalid="false" placeholder="First Name"></span>
			</p>
			<p>
				<span class="wpcf7-form-control-wrap last-name" class="input"><input
					type="text" name="last-name" value="" size="40" class="input"
					 wpcf7-text wpcf7-validates-as-required"
					aria-required="true" aria-invalid="false" placeholder="Last Name"></span>
			</p>
			<p>
				<span class="wpcf7-form-control-wrap address" class="input"><input class="input"
					type="text" name="address" value="" size="40"
					 wpcf7-text wpcf7-validates-as-required"
					aria-required="true" aria-invalid="false"
					placeholder="Street Address"></span>
			</p>
			<p>
				<span class="wpcf7-form-control-wrap city" class="input"><input type="text" class="input"
					name="city" value="" size="40"
					 wpcf7-text wpcf7-validates-as-required"
					aria-required="true" aria-invalid="false" placeholder="City"></span>
			</p>
			<p>
				<span class="wpcf7-form-control-wrap State" ><span
					class="select"><span class="value"><span>Select
								a State</span></span><select name="State"
						class="wpcf7-form-control wpcf7-select wpcf7-validates-as-required"
						aria-required="true" aria-invalid="false" style="opacity: 0;"><option
								value="">Select a State</option>
							<option value="Alaska">Alaska</option>
							<option value="Arizona">Arizona</option>
							<option value="Arkansas">Arkansas</option>
							<option value="California">California</option>
							<option value="Colorado">Colorado</option>
							<option value="Connecticut">Connecticut</option>
							<option value="Delaware">Delaware</option>
							<option value="Florida">Florida</option>
							<option value="Georgia">Georgia</option>
							<option value="Hawaii">Hawaii</option>
							<option value="Idaho">Idaho</option>
							<option value="Illinois">Illinois</option>
							<option value="Indiana">Indiana</option>
							<option value="Iowa">Iowa</option>
							<option value="Kansas">Kansas</option>
							<option value="Kentucky">Kentucky</option>
							<option value="Louisiana">Louisiana</option>
							<option value="Maine">Maine</option>
							<option value="Maryland">Maryland</option>
							<option value="Massachusetts">Massachusetts</option>
							<option value="Michigan">Michigan</option>
							<option value="Minnesota">Minnesota</option>
							<option value="Mississippi">Mississippi</option>
							<option value="Missouri">Missouri</option>
							<option value="Montana">Montana</option>
							<option value="Nebraska">Nebraska</option>
							<option value="Nevada">Nevada</option>
							<option value="New Hampshire">New Hampshire</option>
							<option value="New Jersey">New Jersey</option>
							<option value="New Mexico">New Mexico</option>
							<option value="New York">New York</option>
							<option value="North Carolina">North Carolina</option>
							<option value="North Dakota">North Dakota</option>
							<option value="Ohio">Ohio</option>
							<option value="Oklahoma">Oklahoma</option>
							<option value="Oregon">Oregon</option>
							<option value="Pennsylvania">Pennsylvania</option>
							<option value="Rhode Island">Rhode Island</option>
							<option value="South Carolina">South Carolina</option>
							<option value="South Dakota">South Dakota</option>
							<option value="Tennessee">Tennessee</option>
							<option value="Texas">Texas</option>
							<option value="Utah">Utah</option>
							<option value="Vermont">Vermont</option>
							<option value="Virginia">Virginia</option>
							<option value="Washington">Washington</option>
							<option value="West Virginia">West Virginia</option>
							<option value="Wisconsin">Wisconsin</option>
							<option value="Wyoming">Wyoming</option></select></span></span>
			</p>
			<p>
				<span class="wpcf7-form-control-wrap zip"><input class="input" type="text"
					name="zip" value="" size="40"
					class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required"
					aria-required="true" aria-invalid="false" placeholder="Zip Code"></span>
			</p>
			<p>
				<span class="wpcf7-form-control-wrap phone"><input
					class="input" type="text" name="phone" value="" size="40"
					class="wpcf7-form-control wpcf7-text" aria-invalid="false"
					placeholder="Phone"></span>
			</p>
			<p>
				<span class="wpcf7-form-control-wrap your-email"><input class="input"
					type="email" name="your-email" value="" size="40"
					class="wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email"
					aria-required="true" aria-invalid="false" placeholder="E-mail"></span>
			</p>
			<p>
				<input type="submit" value="Send your inquiry" class="button"
					class="wpcf7-form-control wpcf7-submit"><span
					class="ajax-loader"></span>
			</p>
			<div class="wpcf7-response-output wpcf7-display-none"></div>
		</form>
	</div>
	</article> </section> <aside> <section id="text-11" class="widget widget_text">
	<br><h3>Mailing Address</h3>
	<div class="textwidget">
		<div class="line-widget"></div>
		50 Cregwood road<br> Summit Work<br> New Jersey 12345
	</div>
	</section> </aside> </section>



</div>
</body>
</html>
