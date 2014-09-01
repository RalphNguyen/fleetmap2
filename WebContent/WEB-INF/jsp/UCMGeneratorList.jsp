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
								<li><a href="UCMGenerator.html">Generate UCM</a></li>
								<li class="active"><a href="UCMGeneratorList.html">Generate
										UCM List</a></li>
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
							<span class="meter" style="width: 50%"></span>
						</div>
						<ul class="breadcrumbs">
							<li><a href="home.html">Home</a></li>
							<li><a href="UCMGeneratorList.html">Generate UCM List</a></li>
							<li><a href="UCMGeneratorList.html">Upload input</a></li>
							<li class="current"><a href="UCMGeneratorList.html">Modify
									Input</a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<form:form method="post"
							action="generateUCMConfigurationList.html"
							modelAttribute="UCMConfigurationForm">
							<fieldset>
								<legend>${noOfUcm} radios to allocate IDs</legend>
								<div class="row">
									<div class="large-4 medium-4 columns">
										<div class="row">
											<div class="large-2 medium-2 columns">No.</div>
											<div class="large-5 medium-5 columns">Serial Number</div>
											<div class="large-5 medium-5 columns">User Alias</div>
										</div>
									</div>
									<div class="large-8 medium-8 columns">
										<div class="row">
											<div class="large-2 medium-2 columns">Modulation</div>
											<div class="large-2 medium-2 columns">Zone</div>
											<div class="large-3 medium-3 columns">Entity Name</div>
											<div class="large-2 medium-2 columns">Remedy ID</div>
											<div class="large-3 medium-3 columns">Activation Status</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="large-12 medium-12 columns">
										<c:forEach items="${UCMConfigurationForm.ucmConfigurations}"
											var="ucmConfiguration" varStatus="status">
											<div class="row">
												<div class="large-4 medium-4 columns">
													<div class="row">
														<div class="large-2 medium-2 columns">
															<label><form:checkbox
																	path="ucmConfigurations[${status.index}].updated"
																	checked="checked" /> ${status.count}</label>
														</div>
														<div class="large-5 medium-5 columns">
															<form:input
																path="ucmConfigurations[${status.index}].radio_serial_number" />
															<springForm:errors
																path="ucmConfigurations[${status.index}].radio_serial_number"
																cssClass="error" />
														</div>
														<div class="large-5 medium-5 columns">
															<form:input
																path="ucmConfigurations[${status.index}].radio_user_alias" />
															<springForm:errors
																path="ucmConfigurations[${status.index}].radio_user_alias"
																cssClass="error" />
														</div>
													</div>
												</div>
												<div class="large-8 medium-8 columns">
													<div class="row">
														<div class="large-2 medium-2 columns">
															<form:select
																path="ucmConfigurations[${status.index}].radio_modulation_type_id">
																<form:option value="1">Analog</form:option>
																<form:option value="2">Digital</form:option>
																<form:option value="3">P25</form:option>
															</form:select>
														</div>
														<div class="large-2 medium-2 columns">
															<form:select
																path="ucmConfigurations[${status.index}].zone_id">
																<form:option value="1">Zone 1</form:option>
																<form:option value="2">Zone 2</form:option>
																<form:option value="3">Zone 3</form:option>
															</form:select>
														</div>
														<div class="large-3 medium-3 columns">
															<form:select
																path="ucmConfigurations[${status.index}].entity_name">
																<form:options items="${entityList.entities}"
																	var="entity" itemValue="entity_name"
																	itemLabel="entity_name"></form:options>
															</form:select>
														</div>
														<div class="large-2 medium-2 columns">
															<form:input
																path="ucmConfigurations[${status.index}].remedy_id" />
															<springForm:errors
																path="ucmConfigurations[${status.index}].remedy_id"
																cssClass="error" />
														</div>
														<div class="large-3 medium-3 columns">
															<form:select
																path="ucmConfigurations[${status.index}].activation_status">
																<form:option value="Registered and Activated"
																	selected="selected">Registered and Activated</form:option>
																<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
																<form:option value="Deregistered">Deregistered</form:option>
															</form:select>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</fieldset>
							<div class="row">
								<div class="large-12 medium-12 columns">
									<ul class="button-group">
										<li><input class="small button secondary alert success"
											type="submit" name="approve" value="Generate UCMs" /></li>
										<li><input class="small button" type="submit" name="deny"
											value="Back" /></li>
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