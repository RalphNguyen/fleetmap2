<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>FleetMap Support Tool</title>
</head>
<body>
	<h2>UCM Update</h2>
	<h3>${search_not_found}</h3>
	<form:form method="post" action="searchUCM.html"
		modelAttribute="UCMUpdate">
		<table>
			<tr>
				<td><form:label path="radio_user_alias">Radio User Alias</form:label></td>
				<td><form:input path="radio_user_alias" /></td>
			</tr>
			<tr>
				<td><form:label path="radio_serial_number">Radio Serial Number</form:label></td>
				<td><form:input path="radio_serial_number" /></td>
			</tr>
			<tr>
				<td><form:label path="radio_id">Radio ID</form:label></td>
				<td><form:input path="radio_id" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Search UCM" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>