<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>UCM generation result</title>
</head>
<body>
	<h2>UCM generation done!</h2>
	<h3>One UCM record was inserted to the database</h3>
	<form:form method="post" action="UCMGenerator.html"
		modelAttribute="UCMConfiguration">
		<table>
			<tr>
				<td><form:label path="remedy_id">Remedy ID</form:label></td>
				<td><form:input path="remedy_id" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="id_issued_date">Issued Date</form:label></td>
				<td><form:input path="id_issued_date" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="activation_status">Activation Status</form:label></td>
				<td><form:input path="activation_status" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="radio_id">Radio ID</form:label></td>
				<td><form:input path="radio_id" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="radio_serial_number">Radio Serial Number</form:label></td>
				<td><form:input path="radio_serial_number" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="radio_user_alias">Radio User Alias</form:label></td>
				<td><form:input path="radio_user_alias" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="zone_id">Zone ID</form:label></td>
				<td><form:input path="zone_id" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="entity_name">Entity Name</form:label></td>
				<td><form:input path="entity_name" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="voice_enabled">Voice Enabled</form:label></td>
				<td><form:select path="voice_enabled">
						<form:option value="Yes" selected="selected">Yes</form:option>
						<form:option value="No">No</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="interconnect_enabled">Interconnect Enabled</form:label></td>
				<td><form:select path="interconnect_enabled">
						<form:option value="Yes">Yes</form:option>
						<form:option value="No">No</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="secure_comms_mode">Secure Comms Mode</form:label></td>
				<td><form:input path="secure_comms_mode" /></td>
			</tr>
			<tr>
				<td><form:label path="ucp">UCP</form:label></td>
				<td><form:input path="ucp" /></td>
			</tr>
			<tr>
				<td><form:label path="soft_id">Soft ID</form:label></td>
				<td><form:input path="soft_id" /></td>
			</tr>
			<tr>
				<td><form:label path="radio_type">Radio Type</form:label></td>
				<td><form:input path="radio_type" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="security_group_id">Security Group ID</form:label></td>
				<td><form:input path="security_group_id" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="primary_core_access_point_name_id">Primary AP</form:label></td>
				<td><form:select path="primary_core_access_point_name_id">
						<form:options
							items="${UCMConfiguration.coreAccessPointForm.coreAccessPoints}"
							var="coreaccesspoint" itemValue="core_access_point_id"
							itemLabel="core_access_point_name"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="backup_core_access_point_name_id">Backup Core AP</form:label></td>
				<td><form:select path="backup_core_access_point_name_id">
						<form:options
							items="${UCMConfiguration.coreAccessPointForm.coreAccessPoints}"
							var="coreaccesspoint" itemValue="core_access_point_id"
							itemLabel="core_access_point_name"></form:options>
					</form:select></td>
			</tr>	
			<tr>
				<td colspan="2"><input type="submit" value="Back to UCM Generator" /></td>
			</tr>	
		</table>
	</form:form>
</body>
</html>