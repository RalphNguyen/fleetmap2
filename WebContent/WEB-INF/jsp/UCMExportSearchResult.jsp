<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>FleetMap Support Tool</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/jquery-ui.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
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
	<h2>UCM Export</h2>
	<h3>${search_not_found}</h3>
	<form:form method="post" action="sendUCMClient.html"
		modelAttribute="UCMExport">
		<table>
			<tr>
				<th>UCM ID</th>
				<th>RADIO ID</th>
			</tr>
			<c:forEach items="${UCMExport.ucmExportForm.ucmExports}"
				var="ucmExport">
				<tr>
					<td>${ucmExport.ucm_id}</td>
					<td>${ucmExport.radio_id}</td>
				</tr>
			</c:forEach>
		</table>
		<tr>
			<td colspan="2"><input type="submit" name="approve"
				value="Export" /></td>
			<td><input type="submit" name="deny" value="Back to Export Page" /></td>
		</tr>
	</form:form>
</body>
</html>