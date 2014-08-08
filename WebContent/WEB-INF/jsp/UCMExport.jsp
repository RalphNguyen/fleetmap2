<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>FleetMap Support Tool</title>
<link type="text/css" rel="stylesheet"  href="<c:url value="/resources/css/jquery-ui.css" />"/>	
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
<script>
	$(function() {
		$('#datepicker').datepicker({ dateFormat: 'yy/mm/dd' });
		$('#datepicker2').datepicker({ dateFormat: 'yy/mm/dd' });
	});
</script>
</head>
<body>
	<h2>UCM Export</h2>
	<h3>${search_not_found}</h3>
	<form:form method="post" action="searchUCMExport.html"
		modelAttribute="UCMExport">
		<table>
			<tr>
				<td><form:label path="startDate">Start date</form:label></td>
				<td><form:input path="startDate" id="datepicker"/></td>
			</tr>
			<tr>
				<td><form:label path="endDate">End date</form:label></td>
				<td><form:input path="endDate" id="datepicker2"/></td>
			</tr>		
			<tr>
				<td colspan="2"><input type="submit" value="Search UCM" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>