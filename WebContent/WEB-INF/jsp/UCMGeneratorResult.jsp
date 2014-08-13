<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	href="<c:url value="/resources/css/mystyle1.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
</head>
<title>UCM generation result</title>
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
							<li class="active"><a href="UCMGenerator.html">Generate UCM</a></li>
							<li><a href="UCMGeneratorList.html">Generate UCM List</a></li>
							<li><a href="UCMUpdate.html">Update UCM</a></li>
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
			<div class="row">
				<div class="large-9 push-3 columns">
					<h3>UCM generation result</h3>
					<form:form method="post" action="UCMGeneratorSubmission.html"
						modelAttribute="UCMConfiguration">
						<table>
							<tr>
								<td><form:label path="remedy_id">Remedy ID</form:label></td>
								<td><form:input path="remedy_id" readOnly="true"/></td>
							</tr>
							<tr>
								<td><form:label path="id_issued_date">Issued Date</form:label></td>
								<td><form:input path="id_issued_date" readOnly="true"/></td>
							</tr>
							<tr>
								<td><form:label path="activation_status">Activation Status</form:label></td>
								<td><form:input path="activation_status" readOnly="true" /></td>
							</tr>
							<tr>
								<td><form:label path="radio_id">Radio ID</form:label></td>
								<td><form:input path="radio_id" readOnly="true" /></td>
							</tr>
							<tr>
								<td><form:label path="radio_serial_number">Radio Serial Number</form:label></td>
								<td><form:input path="radio_serial_number" readOnly="true" /></td>
							</tr>
							<tr>
								<td><form:label path="radio_user_alias">Radio User Alias</form:label></td>
								<td><form:input path="radio_user_alias" readOnly="true" /></td>
							</tr>
							<tr>
								<td><form:label path="zone_id">Zone ID</form:label></td>
								<td><form:input path="zone_id" readOnly="true" /></td>
							</tr>
							<tr>
								<td><form:label path="entity_name">Entity Name</form:label></td>
								<td><form:input path="entity_name" readOnly="true" /></td>
							</tr>
							<tr>
								<td><form:label path="voice_enabled">Voice Enabled</form:label></td>
								<td><form:select path="voice_enabled">
										<form:option value="Yes" selected="selected">Yes</form:option>
										<form:option value="No">No</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td><form:label path="interconnect_enabled">Interconnect Enabled</form:label></td>
								<td><form:select path="interconnect_enabled">
										<form:option value="Yes">Yes</form:option>
										<form:option value="No">No</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td><form:label path="secure_comms_mode">Secure Comms Mode</form:label></td>
								<td><form:input path="secure_comms_mode" /></td>
							</tr>
							<tr>
								<td><form:label path="ucp">UCP</form:label></td>
								<td><form:input path="ucp" /></td>
							</tr>
							<tr>
								<td><form:label path="soft_id">Soft ID</form:label></td>
								<td><form:input path="soft_id" /></td>
							</tr>
							<tr>
								<td><form:label path="radio_type">Radio Type</form:label></td>
								<td><form:input path="radio_type" readOnly="true" /></td>
							</tr>
							<tr>
								<td><form:label path="security_group_id">Security Group ID</form:label></td>
								<td><form:input path="security_group_id" readOnly="true" /></td>
							</tr>
							<tr>
								<td><form:label path="primary_core_access_point_name_id">Primary AP</form:label></td>
								<td><form:select path="primary_core_access_point_name_id">
										<form:options
											items="${coreAccessPointForm.coreAccessPoints}"
											var="coreaccesspoint" itemValue="core_access_point_id"
											itemLabel="core_access_point_name"></form:options>
									</form:select></td>
							</tr>
							<tr>
								<td><form:label path="backup_core_access_point_name_id">Backup Core AP</form:label></td>
								<td><form:select path="backup_core_access_point_name_id">
										<form:options
											items="${coreAccessPointForm.coreAccessPoints}"
											var="coreaccesspoint" itemValue="core_access_point_id"
											itemLabel="core_access_point_name"></form:options>
									</form:select></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Submit UCM" /></td>
							</tr>
						</table>
					</form:form>
				</div>
				<div class="large-3 pull-9 columns">
					<ul class="side-nav">
						<li><a href="#">Section 1</a></li>
						<li><a href="#">Section 2</a></li>
						<li><a href="#">Section 3</a></li>
						<li><a href="#">Section 4</a></li>
						<li><a href="#">Section 5</a></li>
						<li><a href="#">Section 6</a></li>
					</ul>
					<p>
						<img
							style="height: auto; max-height: 60px; vertical-align: center;"
							class="logo" src="<c:url value="/resources/img/motorola.png"/>">
					</p>
				</div>
			</div>
		</div>
	</div>

	<!-- FOOTER AREA -->
	<div class="full-width footer-area">
		<div class="row">
			<div class="large-12 columns">&copy; Motorola Solutions 2014</div>
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