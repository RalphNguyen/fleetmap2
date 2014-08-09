<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>FleetMap Support Tool</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/jquery-ui.css" />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/foundation.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/foundation.min.js" />"></script>
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
	<h1>test test test</h1>
	<nav class="row">
		<div class="large-12 columns">
			<h2>Cat Breeds</h2>
			<ul class="button-group radius even-4">
				<li><a class="button" href="#">Maine Coon</a></li>
				<li><a class="button" href="#">Turkish Angora</a></li>
				<li><a class="button" href="#">Russian Blue</a></li>
				<li><a class="button" href="#">Scottish Fold</a></li>
			</ul>
		</div>
	</nav>
	<h1>test test test</h1>
	<h2>UCM Export</h2>
	<h3>${search_not_found}</h3>
	<form:form method="post" action="searchUCMExport.html"
		modelAttribute="UCMExport">
		<table>
			<tr>
				<td><form:label path="startDate">Start date</form:label></td>
				<td><form:input path="startDate" id="datepicker" /></td>
			</tr>
			<tr>
				<td><form:label path="endDate">End date</form:label></td>
				<td><form:input path="endDate" id="datepicker2" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Search UCM" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>