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
	src="<c:url value="/resources/js/Chart.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/responsive-tables.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/myJS.js" />"></script>
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
	</div>
	<!-- CONTENT AREA -->
	<div class="full-width content-area">
		<div class="row">
			<div class="large-12 columns">
				<div class="row">
					<div class="large-8 columns">
						<h1></h1>
						<h3>Dashboard</h3>
						<p>Put the content here</p>
						<div>
							<input type="button" value="Save1" onclick="doAjaxPost();" />
						</div>
						<div>
							<input type="button" value="Save2" onclick="drawOther();" />
						</div>
						<div style="width: 80%">
							<div>
								<canvas id="canvas" height="600" width="600"></canvas>
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