<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>UCM generation result</title>
</head>
<body>
	<h2>UCM generation result</h2>
	<form:form method="post" action="submitUCMConfigurationList.html"
		modelAttribute="UCMConfigurationForm">
		<table>
			<tr>
				<th>No.</th>
				<th>Activation Status</th>
				<th>Remedy ID</th>
				<th>Radio Serial Number</th>
				<th>Radio User Alias</th>
				<th>Zone ID</th>
				<th>Entity Name</th>
			</tr>

			<c:forEach items="${UCMConfigurationForm.ucmConfigurations}"
				var="ucmConfiguration" varStatus="status">
				<tr>
					<td align="center">${status.count}</td>
					<td><form:select
							path="ucmConfigurations[${status.index}].activation_status">
							<form:option value="Registered and Activated" selected="selected">Registered and Activated</form:option>
							<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
							<form:option value="Deregistered">Deregistered</form:option>
						</form:select></td>
					<td><form:input
							path="ucmConfigurations[${status.index}].remedy_id" /></td>
					<td><form:input
							path="ucmConfigurations[${status.index}].radio_serial_number" /></td>
					<td><form:input
							path="ucmConfigurations[${status.index}].radio_user_alias" /></td>
					<td><form:select
							path="ucmConfigurations[${status.index}].zone_id">
							<form:option value="1">Zone 1</form:option>
							<form:option value="2">Zone 2</form:option>
							<form:option value="3">Zone 3</form:option>
						</form:select></td>
					<td><form:select
							path="ucmConfigurations[${status.index}].entity_name">
							<form:options items="${entityList.entities}" var="entity"
								itemValue="entity_name" itemLabel="entity_name"></form:options>
						</form:select></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="Search UCM" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>