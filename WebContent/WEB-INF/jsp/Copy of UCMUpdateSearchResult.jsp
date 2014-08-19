<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<!DOCTYPE html>
<!--[if IE 9]><html class="lt-ie10" lang="en" > <![endif]-->
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FleetMap Support Tool</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/jquery-ui.css" />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/normalize.css" />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/foundation.css" />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/responsive-tables.css" />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/mystyle1.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/responsive-tables.js" />"></script>
</head>
<body>
	<!-- HEADER AREA -->
	<header class="full-width header-area">
		<div class="row">
			<div class="large-12 columns">
				<h2>FleetMap Support Tool</h2>
			</div>
		</div>
	</header>

	<!-- NAVIGATION AREA -->
	<div class="full-width navigation-area">
		<div class="row">
			<div class="large-12 columns">
				<nav class="top-bar" data-topbar>
					<!-- Title Area -->
					<ul class="title-area">
						<li class="name"><a href="home.html"><img
								style="height: auto; max-height: 40px; vertical-align: center;"
								class="logo" src="<c:url value="/resources/img/motorola.png"/>"></a></li>
						<li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
					</ul>
					<!-- The Section wrap -->
					<section class="top-bar-section">
						<!-- Left Nav Section -->
						<ul class="left">
							<li><a href="home.html">Home</a></li>
							<li><a href="UCMGenerator.html">Generate UCM</a></li>
							<li><a href="UCMGeneratorList.html">Generate UCM List</a></li>
							<li class="active"><a href="UCMUpdate.html">Update UCM</a></li>
							<li><a href="UCMExport.html">Export</a></li>
							<li class="has-dropdown"><a href="#">Administration</a>
								<ul class="dropdown">
									<li><a href="#">DB Management</a></li>
									<li><a href="#">Account Management</a></li>
								</ul></li>
						</ul>
						<!-- Right Nav Section -->
						<ul class="right">
						</ul>
					</section>
				</nav>
			</div>
		</div>
	</div>

	<!-- CONTENT AREA -->
	<div class="full-width content-area">
		<div class="row">
			<div class="large-12 columns">
				<div class="row">
					<div class="large-12 columns">
						<p>${search_not_found}</p>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<form:form method="post" action="submitUpdatedUCM.html"
							modelAttribute="UCMUpdate">
							<div class="row">
								<div class="large-12 columns">
									<table>
										<tr>
											<td><form:label path="activation_status">Activation Status</form:label></td>
											<td><form:select path="activation_status">
													<form:option value="Registered and Activated">Registered and Activated</form:option>
													<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
													<form:option value="Deregistered">Deregistered</form:option>
												</form:select></td>
										</tr>
										<tr>
											<td><form:label path="radio_user_alias">Radio User Alias</form:label></td>
											<td><form:input path="radio_user_alias" /></td>
											<td>${check_alias_message}</td>
										</tr>
										<tr>
											<td><form:label path="radio_serial_number">Radio Serial Number</form:label></td>
											<td><form:input path="radio_serial_number" /></td>
											<td>${check_serial_message}</td>
										</tr>
										<tr>
											<td><form:label path="ucp">UCP</form:label></td>
											<td><form:input path="ucp" /></td>
										</tr>
										<tr>
											<td><form:label path="security_group_id">Security Group</form:label></td>
											<td><form:select path="security_group_id">
													<form:options items="${securityGroupForm.securityGroups}"
														var="securitygroup" itemValue="security_group_id"
														itemLabel="security_group"></form:options>
												</form:select></td>
										</tr>
										<tr>
											<td><form:label path="radio_id">Radio ID</form:label></td>
											<td><form:input path="radio_id" disabled="true" /></td>
										</tr>
										<tr>
											<td><form:label path="radio_type">Radio Type</form:label></td>
											<td><form:input path="radio_type" disabled="true" /></td>
										</tr>
										<tr>
											<td><form:label path="radio_modulation_type_id">Radio Modulation Type</form:label></td>
											<td><form:select path="radio_modulation_type_id"
													disabled="true">
													<form:option value="1">Analog</form:option>
													<form:option value="2">Digital</form:option>
													<form:option value="3">P25</form:option>
												</form:select></td>
										</tr>
										<tr>
											<td><form:label path="zone_id">Zone</form:label></td>
											<td><form:select path="zone_id" disabled="true">
													<form:option value="1">Zone 1</form:option>
													<form:option value="2">Zone 2</form:option>
													<form:option value="3">Zone 3</form:option>
												</form:select></td>
										</tr>
										<tr>
											<td><form:label path="remedy_id">Remedy ID</form:label></td>
											<td><form:input path="remedy_id" disabled="true" /></td>
										</tr>
										<tr>
											<td><form:label path="id_issued_date">Id Issued Date</form:label></td>
											<td><form:input path="id_issued_date" disabled="true" /></td>
										</tr>
										<tr>
											<td><form:label path="date_modified">Modified Date</form:label></td>
											<td><form:input path="date_modified" disabled="true" /></td>
										</tr>
									</table>
								</div>
							</div>
							<div class="row">
								<div class="large-8 columns">
									<ul class="button-group [radius round]">
										<li><input class="button [radius round]" type="submit"
											name="approve" value="Update UCM" /></li>
										<li><input class="button [secondary alert success]"
											type="submit" name="deny" value="Back to UCM Update" /></li>
									</ul>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- FOOTER AREA -->
	<div class="full-width footer-area">
		<div class="row">
			<div class="large-12 columns">
				&copy; <a href="http://www.motorolasolutions.com">Motorola
					Solutions 2014</a>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/foundation.min.js" />"></script>
	<script>
		$(document).foundation();
	</script>
</body>
</html>