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
	href="<c:url value="/resources/css/mystyle1.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
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
				<div class="top-nav" data-magellan-expedition="fixed">
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
								<li><a href="home.html">Dashboard</a></li>
								<li class="active"><a href="UCMGenerator.html">Generate
										UCM</a></li>
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
	</div>

	<!-- CONTENT AREA -->
	<div class="full-width content-area">
		<div class="row">
			<div class="large-12 columns">
				<div class="row">
					<div class="large-12 columns">
						<div class="progress large-12 radius round">
							<span class="meter" style="width: 25%"></span>
						</div>
						<ul class="breadcrumbs">
							<li><a href="home.html">Home</a></li>
							<li><a href="UCMGenerator.html">Generate UCM</a></li>
							<li class="current"><a href="UCMGenerator.html">Input
									Request</a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<form:form method="post" action="UCMGenerator.html"
							modelAttribute="UCMConfiguration">
							<fieldset>
								<legend>${message}Please input to generate a UCM Data</legend>
								<div class="row">
									<div class="large-4 medium-4 columns">
										<label>Remedy ID <form:input type="text"
												path="remedy_id" /> <springForm:errors path="remedy_id"
												cssClass="error" />
										</label>
									</div>
									<div class="large-4 medium-4 columns">
										<label>Entity<form:select path="entity_name">
												<form:options items="${entityForm.entities}" var="entity"
													itemValue="entity_name" itemLabel="entity_name"></form:options>
											</form:select></label>
									</div>
									<div class="large-4 medium-4 columns">
										<label>Request No<form:input path="request_no" /> <springForm:errors
												path="request_no" cssClass="error" /></label>
									</div>
								</div>
								<div class="row">
									<div class="large-4 medium-4 columns">
										<label>Radio User Alias<form:input
												path="radio_user_alias" /> <springForm:errors
												path="radio_user_alias" cssClass="error" /></label>
									</div>
									<div class="large-4 medium-4 columns">
										<label>Radio Serial Number<form:input
												path="radio_serial_number" /> <springForm:errors
												path="radio_serial_number" cssClass="error" /></label>
									</div>
									<div class="large-4 medium-4 columns">
										<label>Zone ID<form:select path="zone_id">
												<form:option value="1">Zone 1</form:option>
												<form:option value="2">Zone 2</form:option>
												<form:option value="3">Zone 3</form:option>
											</form:select></label>
									</div>
								</div>
								<div class="row">
									<div class="large-4 medium-4 columns">
										<label>Radio Type<form:select path="radio_type">
												<form:option value="Radio" selected="selected">Radio</form:option>
												<form:option value="Console">Console</form:option>
											</form:select></label>
									</div>
									<div class="large-4 medium-4 columns">
										<label>Radio Modulation Type<form:select
												path="radio_modulation_type_id">
												<form:option value="1">Analog</form:option>
												<form:option value="2">Digital</form:option>
												<form:option value="3">P25</form:option>
											</form:select></label>
									</div>
									<div class="large-4 medium-4 columns">
										<label>Radio user data type<form:select
												path="radio_user_data_type">
												<form:option value="IVD" selected="selected">IVD</form:option>
												<form:option value="HPD">HPD</form:option>
											</form:select>
										</label>
									</div>
								</div>
								<div class="row">
									<div class="large-4 medium-4 columns">
										<label>Activation Status<form:select
												path="activation_status">
												<form:option value="Registered and Activated"
													selected="selected">Registered and Activated</form:option>
												<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
												<form:option value="Deregistered">Deregistered</form:option>
											</form:select></label>
									</div>
									<div class="large-4 medium-4 columns">
										<label>Sub Entity<form:input path="sub_entity" /></label>
									</div>
									<div class="large-4 medium-4 columns">
										<label>UCP<form:input path="ucp" /></label>
									</div>
								</div>
							</fieldset>
							<div class="row">
								<div class="large-4 columns">
									<input class="small button" type="submit"
										value="Generate UCM" />
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