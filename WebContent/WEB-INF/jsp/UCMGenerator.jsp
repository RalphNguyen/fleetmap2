<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>FleetMap Support Tool</title>
</head>
<body>
	<h2>UCM Generator</h2>
	<form:form method="post" action="generateUCM.html"
		modelAttribute="UCMConfiguration">
		<table>
			<tr>
				<td><form:label path="remedy_id">Remedy ID</form:label></td>
				<td><form:input path="remedy_id" /></td>
			</tr>
			<tr>
				<td><form:label path="radio_type">Radio Type</form:label></td>
				<td><form:select path="radio_type">
						<form:option value="Radio" selected="selected">Radio</form:option>
						<form:option value="Console">Console</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="radio_user_data_type">Radio User Data Type</form:label></td>
				<td><form:select path="radio_user_data_type">
						<form:option value="IVD" selected="selected">IVD</form:option>
						<form:option value="HPD">HPD</form:option>
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
				<td><form:label path="zone_id">Zone ID</form:label></td>
				<td><form:select path="zone_id">
						<form:option value="1">Zone 1</form:option>
						<form:option value="2">Zone 2</form:option>
						<form:option value="3">Zone 3</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="entity_name">Entity Name</form:label></td>
				<td><form:select path="entity_name">
						<form:options items="${UCMConfiguration.entityForm.entities}"
							var="entity" itemValue="entity_name" itemLabel="entity_name"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="request_no">Entity Request Number</form:label></td>
				<td><form:input path="request_no" /></td>
			</tr>
			<tr>
				<td><form:label path="sub_entity">Sub-Entity</form:label></td>
				<td><form:input path="sub_entity" /></td>
			</tr>
			<tr>
				<td><form:label path="radio_modulation_type_id">Radio Modulation Type ID</form:label></td>
				<td><form:select path="radio_modulation_type_id">
						<form:option value="1">Analog</form:option>
						<form:option value="2">Digital</form:option>
						<form:option value="3" selected="selected">P25</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="activation_status">Activation Status</form:label></td>
				<td><form:select path="activation_status">
						<form:option value="Registered and Activated" selected="selected">Registered and Activated</form:option>
						<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
						<form:option value="Deregistered">Deregistered</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Generate UCM" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>