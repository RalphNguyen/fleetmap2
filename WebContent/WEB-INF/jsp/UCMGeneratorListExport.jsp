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
				<div class="progress large-12 radius round">
					<span class="meter" style="width: 100%"></span>
				</div>
				<ul class="breadcrumbs">
					<li><a href="home.html">Home</a></li>
					<li><a href="UCMGeneratorList.html">Generate UCM List</a></li>
					<li><a href="UCMGeneratorList.html">Upload input</a></li>
					<li class="unavailable"><a href="#">Modify Input</a></li>
					<li class="unvailable"><a href="#">Configure
							UCM</a></li>
					<li class="current"><a href="#">Export</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="large-12 columns">
				<div class="row">
					<div class="large-12 columns">
						<form:form method="post" action="UCMGeneratorListExport.html"
							modelAttribute="UCMConfigurationForm">
							<fieldset>
								<legend>${noOfUcm} UCMs were saved to the database as
									below</legend>
								<div class="row">
									<div class="large-12 column">
										<c:forEach items="${UCMConfigurationForm.ucmConfigurations}"
											var="ucmConfiguration" varStatus="status">
											<dl class="accordion" data-accordion>
												<dd class="accordion-navigation">
													<a href="#panel${status.count}">No.${status.count}</a>
													<div id="panel${status.count}" class="content active">
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Remedy ID <form:input type="text"
																		path="ucmConfigurations[${status.index}].remedy_id"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Issued Date<form:input
																		path="ucmConfigurations[${status.index}].id_issued_date"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Activation Status <form:input
																		path="ucmConfigurations[${status.index}].activation_status"
																		readOnly="true" /></label>
															</div>
														</div>
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Radio ID<form:input
																		path="ucmConfigurations[${status.index}].radio_id"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Radio Serial Number <form:input
																		path="ucmConfigurations[${status.index}].radio_serial_number"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Radio User Alias <form:input
																		path="ucmConfigurations[${status.index}].radio_user_alias"
																		readOnly="true" /></label>
															</div>
														</div>
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Zone ID <form:input
																		path="ucmConfigurations[${status.index}].zone_id"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Entity <form:input
																		path="ucmConfigurations[${status.index}].entity_name"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Radio Type <form:input
																		path="ucmConfigurations[${status.index}].radio_type"
																		readOnly="true" /></label>
															</div>
														</div>
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Security Group ID <form:input
																		path="ucmConfigurations[${status.index}].security_group_id"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Voice Enabled <form:input
																		path="ucmConfigurations[${status.index}].voice_enabled"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Interconnect Enabled <form:input
																		path="ucmConfigurations[${status.index}].interconnect_enabled"
																		readOnly="true" />
																</label>
															</div>
														</div>
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Secure Comms Mode<form:input
																		path="ucmConfigurations[${status.index}].secure_comms_mode"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>UCP<form:input
																		path="ucmConfigurations[${status.index}].ucp"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Soft ID <form:input
																		path="ucmConfigurations[${status.index}].soft_id"
																		readOnly="true" /></label>
															</div>
														</div>
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Primary AP <form:input
																		path="ucmConfigurations[${status.index}].primary_core_access_point_name_id"
																		readOnly="true" />
																</label>
															</div>
															<div class="large-4 medium-4 columns end">
																<label>Backup Core AP<form:input
																		path="ucmConfigurations[${status.index}].backup_core_access_point_name_id"
																		readOnly="true" />
																</label>
															</div>
														</div>
													</div>
												</dd>
											</dl>
										</c:forEach>
									</div>
								</div>
							</fieldset>
							<div class="row">
								<div class="large-12 columns">
									<ul class="button-group">
										<li><input class="small button secondary alert success" type="submit"
											name="ucm" value="Export UCM" /></li>
										<li><input class="small button secondary alert success" type="submit"
											name="remedy" value="Export Remedy" /></li>
										<li><input class="small button"
											type="submit" name="back" value="Generate UCMs again!" /></li>
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