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
<script>
	$(function() {
		$('#datepicker').datepicker({
			dateFormat : 'yy/mm/dd'
		});
		$('#datepicker2').datepicker({
			dateFormat : 'yy/mm/dd'
		});
	});
</script>
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
								<li><a href="UCMUpdate.html">Update UCM</a></li>
								<li class="active"><a href="UCMExport.html">Export</a></li>
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
							<span class="meter" style="width: 100%"></span>
						</div>
						<ul class="breadcrumbs">
							<li><a href="home.html">Home</a></li>
							<li><a href="UCMExport.html">Export UCM</a></li>
							<li class="unavailable"><a href="UCMExport.html">Search
									Input</a></li>
							<li class="unavailable"><a href="UCMExport.html">Export</a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<div class="row">
							<div class="large-12 columns">
								<p>${message}</p>
							</div>
						</div>
						<div class="row">
							<div class="large-12 columns">
								<form:form method="post" action="UCMExport.html"
									modelAttribute="UCMExport">
									<div class="row">
										<div class="large-12 columns">
											<div class="row">
												<dl class="accordion" data-accordion>
													<dd class="accordion-navigation">
														<div id="panel1" class="content active">
															<div class="row">
																<div class="large-12 columns">
																	<div class="row">
																		<div class="large-12 columns">
																			<label><form:checkbox
																					path="exportSearchInput.searchByIdIssuedDate"
																					checked="checked" /> Search by ID issued date</label>
																		</div>
																	</div>
																	<div class="row">
																		<div class="large-4 medium-4 columns">
																			<label>Start Date</label>
																			<form:input path="exportSearchInput.startDate"
																				id="datepicker"></form:input>

																		</div>
																		<div class="large-4 medium-4 columns end">
																			<label>End Date<form:input
																					path="exportSearchInput.endDate" id="datepicker2" />
																			</label>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</dd>
												</dl>
											</div>
											<div class="row">
												<dl class="accordion" data-accordion>
													<dd class="accordion-navigation">
														<a href="#panel2">Advanced search</a>
														<div id="panel2" class="content">
															<div class="row">
																<div class="large-5 medium-5 columns">
																	<div class="row">
																		<div class="large-12 columns">
																			<label><form:checkbox
																					id="entityExportSearchCheckBox"
																					path="exportSearchInput.searchByEntity" /> Entity</label>
																		</div>
																		<div class="row">
																			<div class="large-12 columns">
																				<form:select id="entityExportSearchInput"
																					path="exportSearchInput.entity_name">
																					<form:options
																						items="${UCMExport.entityForm.entities}"
																						var="entity" itemValue="entity_name"
																						itemLabel="entity_name"></form:options>
																				</form:select>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="large-2 medium-2 columns">
																	<div class="row">
																		<div class="large-12 columns">
																			<label><form:checkbox
																					id="radioModulationTypeExportSearchCheckBox"
																					path="exportSearchInput.searchByRadioModulationType" />
																				Modulation Type</label>
																		</div>
																		<div class="row">
																			<div class="large-12 columns">
																				<form:select
																					id="radioModulationTypeExportSearchInput"
																					path="exportSearchInput.radio_modulation_type_id">
																					<form:option value="1">Analog</form:option>
																					<form:option value="2">Digital</form:option>
																					<form:option value="3">P25</form:option>
																				</form:select>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="large-2 medium-2 columns">
																	<div class="row">
																		<div class="large-12 columns">
																			<label><form:checkbox
																					id="zoneIDExportSearchCheckBox"
																					path="exportSearchInput.searchByZoneId" /> Zone</label>
																		</div>
																		<div class="row">
																			<div class="large-12 columns">
																				<form:select id="zoneIDExportSearchInput"
																					path="exportSearchInput.zone_id">
																					<form:option value="1">Zone 1</form:option>
																					<form:option value="2">Zone 2</form:option>
																					<form:option value="3">Zone 3</form:option>
																				</form:select>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="large-3 medium-3 columns">
																	<div class="row">
																		<div class="large-12 columns">
																			<label><form:checkbox
																					id="radioStatusExportSearchCheckBox"
																					path="exportSearchInput.searchByStatus" /> Status</label>
																		</div>
																		<div class="row">
																			<div class="large-12 columns">
																				<form:select id="radioStatusExportSearchInput"
																					path="exportSearchInput.activation_status">
																					<form:option value="Registered and Activated"
																						selected="selected">Registered and Activated</form:option>
																					<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
																					<form:option value="Deregistered">Deregistered</form:option>
																				</form:select>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="large-4 medium-4 columns">
																	<div class="row">
																		<div class="large-12 columns">
																			<label><form:checkbox
																					id="radioSerialNumberExportSearchCheckBox"
																					path="exportSearchInput.searchByRadioSerialNumber" />
																				Serial Number</label>
																		</div>
																		<div class="row">
																			<div class="large-12 columns">
																				<form:input id="radioSerialNumberExportSearchInput"
																					path="exportSearchInput.radio_serial_number" />
																			</div>
																		</div>
																	</div>
																</div>
																<div class="large-4 medium-4 columns">
																	<div class="row">
																		<div class="large-12 columns">
																			<label><form:checkbox
																					id="radioIDExportSearchCheckBox"
																					path="exportSearchInput.searchByRadioId" /> Radio
																				ID</label>
																		</div>
																		<div class="row">
																			<div class="large-12 columns">
																				<form:input id="radioIDExportSearchInput"
																					path="exportSearchInput.radio_id" />
																			</div>
																		</div>
																	</div>
																</div>
																<div class="large-4 medium-4 columns">
																	<div class="row">
																		<div class="large-12 columns">
																			<label><form:checkbox
																					id="remedyIDExportSearchCheckBox"
																					path="exportSearchInput.searchByRemedyId" />
																				Remedy ID</label>
																		</div>
																		<div class="row">
																			<div class="large-12 columns">
																				<form:input id="remedyIDExportSearchInput"
																					path="exportSearchInput.remedy_id" />
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</dd>
												</dl>
											</div>
										</div>
									</div>
									</br>
									<div class="row">
										<div class="large-8 columns">
											<input class="small button" type="submit"
												value="Search UCM" />
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="large-12 columns">
						<div class="row">
							<div class="large-12 columns">
								<p>There are ${noOfUcm} UCMs as the following:</p>
							</div>
						</div>
						<div class="row">
							<div class="large-12 medium-12 columns">
								<form:form method="post" action="UCMExportResult.html"
									modelAttribute="UCMExport">
									<div class="row">
										<div class="large-12 medium-12 columns">
											<table class="responsive">
												<tr>
													<th>UCM ID</th>
													<th>Radio ID</th>
													<th>Status</th>
													<th>Type</th>
													<td>Serial Number</td>
													<td>User Alias</td>
													<td>Radio User Data Type</td>
													<td>Issued Date</td>
													<td>Date Modified</td>
													<td>Voice Enabled</td>
													<td>Interconnect Enabled</td>
													<td>Emergency Alarm Comments</td>
													<td>Secure Comms Mode</td>
													<td>Data Capabilities</td>
													<td>Direct Dial Number</td>
													<td>Secure Land To Mobile Start Mode</td>
													<td>Interconnect Secure Key Reference</td>
													<td>Ip Address Assignment</td>
													<td>Ip Address</td>
													<td>Generate Icmp Message</td>
													<td>Source Address Checking</td>
													<td>Ready Timer</td>
													<td>Data Agency Group</td>
													<td>Notes</td>
													<td>Ucp</td>
													<td>Soft id</td>
													<td>Security Group Id</td>
													<td>Radio Site Access Profile Id</td>
													<td>Remedy Id</td>
													<td>Radio User Interconnect Profile Id</td>
													<td>Backup Core AP</td>
													<td>Primary Core AP</td>
												</tr>
												<c:forEach items="${UCMExport.ucmExportForm.ucmExports}"
													var="ucmExport">
													<tr>
														<td>${ucmExport.ucm_id}</td>
														<td>${ucmExport.radio_id}</td>
														<td>${ucmExport.activation_status}</td>
														<td>${ucmExport.radio_type}</td>
														<td>${ucmExport.radio_serial_number}</td>
														<td>${ucmExport.radio_user_alias}</td>
														<td>${ucmExport.radio_user_data_type}</td>
														<td>${ucmExport.id_issued_date}</td>
														<td>${ucmExport.date_modified}</td>
														<td>${ucmExport.voice_enabled}</td>
														<td>${ucmExport.interconnect_enabled}</td>
														<td>${ucmExport.emergency_alarm_comments}</td>
														<td>${ucmExport.secure_comms_mode}</td>
														<td>${ucmExport.data_capabilities}</td>
														<td>${ucmExport.direct_dial_number}</td>
														<td>${ucmExport.secure_land_to_mobile_start_mode}</td>
														<td>${ucmExport.interconnect_secure_key_reference}</td>
														<td>${ucmExport.ip_address_assignment}</td>
														<td>${ucmExport.ip_address}</td>
														<td>${ucmExport.generate_icmp_message}</td>
														<td>${ucmExport.source_address_checking}</td>
														<td>${ucmExport.ready_timer}</td>
														<td>${ucmExport.data_agency_group}</td>
														<td>${ucmExport.notes}</td>
														<td>${ucmExport.ucp}</td>
														<td>${ucmExport.soft_id}</td>
														<td>${ucmExport.security_group_id}</td>
														<td>${ucmExport.radio_site_access_profile_id}</td>
														<td>${ucmExport.remedy_id}</td>
														<td>${ucmExport.radio_user_interconnect_profile_id}</td>
														<td>${ucmExport.backup_core_access_point_name_id}</td>
														<td>${ucmExport.primary_core_access_point_name_id}</td>
													</tr>
												</c:forEach>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="large-12 columns">
											<ul class="button-group">
												<li><input class="small button secondary alert success"
													type="submit" name="approve" value="Export" /></li>
												<li><input class="small button" type="submit" name="deny"
													value="Do it again!" /></li>
											</ul>
										</div>
									</div>
								</form:form>
							</div>
						</div>
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
		src="<c:url value="/resources/js/foundation.min.js" />"></script>
	<script>
		$(document).foundation();
		$("#remedyIDExportSearchInput").change(function() {
			$("#remedyIDExportSearchCheckBox").prop('checked', true);
		});
		$("#radioIDExportSearchInput").change(function() {
			if (isNaN($(this).val())) {
				alert("Radio ID needed to be an integer");
				$(this).val("0");
				$("#radioIDExportSearchCheckBox").prop('checked', false);
			} else {
				$("#radioIDExportSearchCheckBox").prop('checked', true);
			}
		});
		$("#radioSerialNumberExportSearchInput").change(function() {
			$("#radioSerialNumberExportSearchCheckBox").prop('checked', true);
		});
		$("#radioStatusExportSearchInput").change(function() {
			$("#radioStatusExportSearchCheckBox").prop('checked', true);
		});
		$("#zoneIDExportSearchInput").change(function() {
			$("#zoneIDExportSearchCheckBox").prop('checked', true);
		});
		$("#radioModulationTypeExportSearchInput").change(
				function() {
					$("#radioModulationTypeExportSearchCheckBox").prop(
							'checked', true);
				});
		$("#entityExportSearchInput").change(function() {
			$("#entityExportSearchCheckBox").prop('checked', true);
		});
	</script>
</body>
</html>