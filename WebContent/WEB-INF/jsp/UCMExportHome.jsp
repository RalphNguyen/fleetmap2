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
<script type="text/javascript"
	src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
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
							<li class="active"><a href="home.html">Home</a></li>
							<li><a href="UCMGenerator.html">Generate UCM</a></li>
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
					<h3>UCM Export</h3>
					<p>${search_not_found}</p>
					<form:form method="post" action="searchUCMExport.html"
						modelAttribute="UCMExport">
						<table>
							<tr>
								<td>Search by ID issued date?</td>
								<td><form:checkbox
										path="exportSearchInput.searchByIdIssuedDate"
										checked="checked"></form:checkbox></td>
							</tr>
							<tr>
								<td><form:label path="exportSearchInput.startDate">Start Issued Date</form:label></td>
								<td><form:input path="exportSearchInput.startDate"
										id="datepicker" /></td>

							</tr>
							<tr>
								<td><form:label path="exportSearchInput.endDate">End Issued Date</form:label></td>
								<td><form:input path="exportSearchInput.endDate"
										id="datepicker2" /></td>
							</tr>
							<tr>
								<td>Search by allocated agency?</td>
								<td><form:checkbox path="exportSearchInput.searchByEntity"></form:checkbox></td>
							</tr>
							<tr>
								<td><form:label path="exportSearchInput.entity_name">Allocated Agency</form:label></td>
								<td><form:select path="exportSearchInput.entity_name">
										<form:options items="${UCMExport.entityForm.entities}"
											var="entity" itemValue="entity_name" itemLabel="entity_name"></form:options>
									</form:select></td>
							</tr>
							<tr>
								<td>Search by Zone?</td>
								<td><form:checkbox path="exportSearchInput.searchByZoneId"></form:checkbox></td>
							</tr>
							<tr>
								<td><form:label path="exportSearchInput.zone_id">Zone ID</form:label></td>
								<td><form:select path="exportSearchInput.zone_id">
										<form:option value="1">Zone 1</form:option>
										<form:option value="2">Zone 2</form:option>
										<form:option value="3">Zone 3</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td>Search by Radio Serial Number?</td>
								<td><form:checkbox
										path="exportSearchInput.searchByRadioSerialNumber"></form:checkbox></td>
							</tr>
							<tr>
								<td><form:label
										path="exportSearchInput.radio_serial_number">Radio Serial Number</form:label></td>
								<td><form:input
										path="exportSearchInput.radio_serial_number" /></td>
							</tr>
							<tr>
								<td>Search by activation status?</td>
								<td><form:checkbox path="exportSearchInput.searchByStatus"></form:checkbox></td>
							</tr>
							<tr>
								<td><form:label path="exportSearchInput.activation_status">Activation Status</form:label></td>
								<td><form:select path="exportSearchInput.activation_status">
										<form:option value="Registered and Activated"
											selected="selected">Registered and Activated</form:option>
										<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
										<form:option value="Deregistered">Deregistered</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td>Search by Remedy ID?</td>
								<td><form:checkbox
										path="exportSearchInput.searchByRemedyId"></form:checkbox></td>
							</tr>
							<tr>
								<td><form:label path="exportSearchInput.remedy_id">Remedy ID</form:label></td>
								<td><form:input path="exportSearchInput.remedy_id" /></td>
							</tr>
							<tr>
								<td>Search by Radio ID?</td>
								<td><form:checkbox path="exportSearchInput.searchByRadioId"></form:checkbox></td>
							</tr>
							<tr>
								<td><form:label path="exportSearchInput.radio_id">Remedy ID</form:label></td>
								<td><form:input path="exportSearchInput.radio_id" /></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Search UCM" /></td>
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
		src="<c:url value="/resources/js/foundation.min.js" />"></script>
	<script>
		$(document).foundation();
	</script>
</body>
</html>