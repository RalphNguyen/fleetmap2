<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>FleetMap Support Tool</title>
</head>
<body>
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