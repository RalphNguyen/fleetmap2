<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>UCM Search result</title>
</head>
<body>
	<h2>UCM search result</h2>
	<h3>${search_not_found}</h3>
	<form:form method="post" action="submitUpdatedUCM.html"
		modelAttribute="UCMUpdate">
		<table>
			<tr>
				<td><form:label path="activation_status">Activation Status</form:label></td>
				<td><form:select path="activation_status">
						<form:option value="Registered and Activated">Registered and Activated</form:option>
						<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
						<form:option value="Deregistered">Deregistered</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="radio_user_alias">Radio User Alias</form:label></td>
				<td><form:input path="radio_user_alias" /></td>
				<td>${check_alias_message}</td>
			</tr>
			<tr>
				<td><form:label path="radio_serial_number">Radio Serial Number</form:label></td>
				<td><form:input path="radio_serial_number" /></td>
				<td>${check_serial_message}</td>
			</tr>
			<tr>
				<td><form:label path="ucp">UCP</form:label></td>
				<td><form:input path="ucp" /></td>
			</tr>
			<tr>
				<td><form:label path="security_group_id">Security Group</form:label></td>
				<td><form:select path="security_group_id">
						<form:options
							items="${UCMUpdate.securityGroupForm.securityGroups}"
							var="securitygroup" itemValue="security_group_id"
							itemLabel="security_group"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="radio_id">Radio ID</form:label></td>
				<td><form:input path="radio_id" disabled="true" /></td>
			</tr>
			<tr>
				<td><form:label path="radio_type">Radio Type</form:label></td>
				<td><form:input path="radio_type" disabled="true" /></td>
			</tr>
			<tr>
				<td><form:label path="radio_modulation_type_id">Radio Modulation Type</form:label></td>
				<td><form:select path="radio_modulation_type_id"
						disabled="true">
						<form:option value="1">Analog</form:option>
						<form:option value="2">Digital</form:option>
						<form:option value="3">P25</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="zone_id">Zone</form:label></td>
				<td><form:select path="zone_id" disabled="true">
						<form:option value="1">Zone 1</form:option>
						<form:option value="2">Zone 2</form:option>
						<form:option value="3">Zone 3</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="remedy_id">Remedy ID</form:label></td>
				<td><form:input path="remedy_id" disabled="true" /></td>
			</tr>
			<tr>
				<td><form:label path="id_issued_date">Id Issued Date</form:label></td>
				<td><form:input path="id_issued_date" disabled="true" /></td>
			</tr>
			<tr>
				<td><form:label path="date_modified">Modified Date</form:label></td>
				<td><form:input path="date_modified" disabled="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="approve" value="Update UCM" /></td>
				<td><input type="submit" name="deny" value="Back to UCM Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>