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
							<li><a href="UCMUpdate.html">Update UCM</a></li>
							<li><a href="UCMUpdate.html">Search UCM</a></li>
							<li class="current"><a href="UCMUpdate.html">Search
									Result</a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<div class="row">
							<div class="large-12 columns">
								<p>${search_not_found}</p>
							</div>
						</div>
						<div class="row">
							<div class="large-12 columns">
								<form:form method="post" action="UCMUpdate.html"
									modelAttribute="UCMUpdate">
									<fieldset>
										<legend>Search input</legend>
										<div class="row">
											<div class="large-4 medium-4 columns">
												<div class="row">
													<div class="large-12 columns">
														<label><form:checkbox
																id="radioUserAliasUpdateSearchCheckBox"
																path="ucmUpdateSearchInput.searchByRadioUserAlias" />
															Radio User Alias</label>
													</div>
													<div class="row">
														<div class="large-12 columns">
															<form:input id="radioUserAliasUpdateSearchInput"
																path="ucmUpdateSearchInput.radio_user_alias" />
														</div>
													</div>
												</div>
											</div>
											<div class="large-4 medium-4 columns">
												<div class="row">
													<div class="large-12 columns">
														<label><form:checkbox
																id="radioSerialNumberUpdateSearchCheckBox"
																path="ucmUpdateSearchInput.searchByRadioSerialNumber" />
															Radio Serial Number</label>
													</div>
													<div class="row">
														<div class="large-12 columns">
															<form:input id="radioSerialNumberUpdateSearchInput"
																path="ucmUpdateSearchInput.radio_serial_number" />
														</div>
													</div>
												</div>
											</div>
											<div class="large-4 medium-4 columns">
												<div class="row">
													<div class="large-12 columns">
														<label><form:checkbox
																id="radioIDUpdateSearchCheckBox"
																path="ucmUpdateSearchInput.searchByRadioID" /> Radio ID</label>
													</div>
													<div class="row">
														<div class="large-12 columns">
															<form:input id="radioIDUpdateSearchInput"
																path="ucmUpdateSearchInput.radio_id" />
														</div>
													</div>
												</div>
											</div>
										</div>
									</fieldset>
									<div class="row">
										<div class="large-8 columns">
											<input id="updateSearchButton" disabled class="small button"
												type="submit" value="Search UCM" />
										</div>
									</div>

								</form:form>

							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="large-12 columns">
						<p>${message}</p>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<form:form method="post" action="submitUpdatedUCM.html"
							modelAttribute="UCMUpdate">
							<fieldset>
								<legend>Search result</legend>
								<div class="row">
									<div class="large-12 columns">
										<c:forEach
											items="${UCMUpdate.ucmConfigurationForm.ucmConfigurations}"
											var="ucmConfiguration" varStatus="status">
											<label>No.${status.count} <form:checkbox
													path="ucmConfigurationForm.ucmConfigurations[${status.index}].updated" />
												Update this UCM?
											</label>
											<dl class="accordion" data-accordion>
												<dd class="accordion-navigation">
													<a href="#panel${status.count}-1">Updated fields</a>
													<div id="panel${status.count}-1" class="content active">
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Activation Status <form:select
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].activation_status">
																		<form:option value="Registered and Activated">Registered and Activated</form:option>
																		<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
																		<form:option value="Deregistered">Deregistered</form:option>
																	</form:select>
																</label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Radio Serial Number <form:input
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].radio_serial_number" />
																	<springForm:errors
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].radio_serial_number"
																		cssClass="error" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Radio User Alias <form:input
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].radio_user_alias" />
																	<springForm:errors
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].radio_user_alias"
																		cssClass="error" /></label>
															</div>
														</div>
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Security Group ID <form:select
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].security_group_id">
																		<form:options
																			items="${securityGroupForm.securityGroups}"
																			var="securitygroup" itemValue="security_group_id"
																			itemLabel="security_group"></form:options>
																	</form:select></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>UCP<form:input
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].ucp" />
																	<springForm:errors
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].ucp"
																		cssClass="error" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Radio Type <form:select
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].radio_type">
																		<form:option value="Radio">Radio</form:option>
																		<form:option value="Console">Console</form:option>
																	</form:select></label>
															</div>
														</div>
													</div>
												</dd>
											</dl>
											<dl class="accordion" data-accordion>
												<dd class="accordion-navigation">
													<a href="#panel${status.count}-2">Basic Information</a>
													<div id="panel${status.count}-2" class="content active">
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Radio ID<form:input
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].radio_id"
																		readOnly="true" /></label>
															</div>

															<div class="large-4 medium-4 columns">
																<label>Remedy ID <form:input type="text"
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].remedy_id"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns">
																<label>Zone ID <form:input
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].zone_id"
																		readOnly="true" /></label>
															</div>
														</div>
														<div class="row">
															<div class="large-4 medium-4 columns">
																<label>Issued Date<form:input
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].id_issued_date"
																		readOnly="true" /></label>
															</div>
															<div class="large-4 medium-4 columns end">
																<label>Modified Date<form:input
																		path="ucmConfigurationForm.ucmConfigurations[${status.index}].date_modified"
																		readOnly="true" /></label>
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
								<div class="large-8 columns">
									<ul class="button-group">
										<li><input class="small button secondary alert success"
											type="submit" name="approve" value="Update UCM" /></li>
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
		$("#radioIDUpdateSearchInput").change(function() {
			if (isNaN($(this).val())) {
				alert("Radio ID needed to be an integer");
				$(this).val("0");
				$("#updateSearchButton").attr("disabled", "true");
				$("#radioIDUpdateSearchCheckBox").prop('checked', false);
			} else {
				$("#radioIDUpdateSearchCheckBox").prop('checked', true);
				$("#updateSearchButton").removeAttr("disabled");
			}
		});
		$("#radioSerialNumberUpdateSearchInput").change(function() {
			$("#radioSerialNumberUpdateSearchCheckBox").prop('checked', true);
			$("#updateSearchButton").removeAttr("disabled");
		});
		$("#radioUserAliasUpdateSearchInput").change(function() {
			$("#radioUserAliasUpdateSearchCheckBox").prop('checked', true);
			$("#updateSearchButton").removeAttr("disabled");
		});
	</script>
</body>
</html>