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
				<div class="row">
					<div class="large-12 columns">
						<nav class="top-bar" data-topbar>
							<!-- Title Area -->
							<ul class="title-area">
								<li class="name"><a href="home.html"><img
										style="height: auto; max-height: 40px; vertical-align: center;"
										class="logo"
										src="<c:url value="/resources/img/motorola.png"/>"></a></li>
								<li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
							</ul>

							<!-- The Section wrap -->
							<section class="top-bar-section">

								<!-- Left Nav Section -->
								<ul class="left">
									<li><a href="home.html">Home</a></li>
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
	</div>

	<!-- CONTENT AREA -->
	<div class="full-width content-area">
		<div class="row">
			<div class="large-12 columns">
				<div class="row">
					<div class="large-12 columns">
						<h3>${message}</h3>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<form:form method="post" action="UCMExport.html"
							modelAttribute="UCMExport">
							<div class="row">
								<div class="large-12 columns">
									<dl class="accordion" data-accordion>
										<dd class="accordion-navigation">
											<div id="panel1" class="content active">
												<div class="row">
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
										</dd>
									</dl>
									<dl class="accordion" data-accordion>
										<dd class="accordion-navigation">
											<a href="#panel2">Advanced search</a>
											<div id="panel2" class="content">
												<div class="row">
													<div class="large-6 medium-6 columns">
														<div class="row">
															<div class="large-12 columns">
																<label><form:checkbox
																		path="exportSearchInput.searchByEntity" /> Entity</label>
															</div>
															<div class="row">
																<div class="large-12 columns">
																	<form:select path="exportSearchInput.entity_name">
																		<form:options items="${UCMExport.entityForm.entities}"
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
																		path="exportSearchInput.searchByZoneId" /> Zone</label>
															</div>
															<div class="row">
																<div class="large-12 columns">
																	<form:select path="exportSearchInput.zone_id">
																		<form:option value="1">Zone 1</form:option>
																		<form:option value="2">Zone 2</form:option>
																		<form:option value="3">Zone 3</form:option>
																	</form:select>
																</div>
															</div>
														</div>
													</div>
													<div class="large-4 medium-4 columns">
														<div class="row">
															<div class="large-12 columns">
																<label><form:checkbox
																		path="exportSearchInput.searchByStatus" /> Status</label>
															</div>
															<div class="row">
																<div class="large-12 columns">
																	<form:select path="exportSearchInput.activation_status">
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
																		path="exportSearchInput.searchByRadioSerialNumber" />
																	Serial Number</label>
															</div>
															<div class="row">
																<div class="large-12 columns">
																	<form:input
																		path="exportSearchInput.radio_serial_number" />
																</div>
															</div>
														</div>
													</div>
													<div class="large-4 medium-4 columns">
														<div class="row">
															<div class="large-12 columns">
																<label><form:checkbox
																		path="exportSearchInput.searchByRadioId" /> Radio ID</label>
															</div>
															<div class="row">
																<div class="large-12 columns">
																	<form:input path="exportSearchInput.radio_id" />
																</div>
															</div>
														</div>
													</div>
													<div class="large-4 medium-4 columns">
														<div class="row">
															<div class="large-12 columns">
																<label><form:checkbox
																		path="exportSearchInput.searchByRemedyId" /> Remedy
																	ID</label>
															</div>
															<div class="row">
																<div class="large-12 columns">
																	<form:input path="exportSearchInput.remedy_id" />
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
							</br>
							<div class="row">
								<div class="large-8 columns">
									<input class="button [radius round]" type="submit"
										value="Search UCM" />
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
		src="<c:url value="/resources/js/foundation.min.js" />"></script>
	<script>
		$(document).foundation();
	</script>
</body>
</html>