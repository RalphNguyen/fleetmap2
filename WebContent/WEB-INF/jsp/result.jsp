<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>UCM generation result</title>
</head>
<body>
	<h2>UCM generation result</h2>
	<form:form method="post" action="save.html">
		<table>
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Lastname</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
			<c:forEach items="${inputList.ucmGeneratorInputs}"
				var="UCMGeneratorInput" varStatus="status">
				<tr>
					<td align="center">${status.count}</td>
					<td><input
						name="ucmGeneratorInputs[${status.index}].remedy_id"
						value="${UCMGeneratorInput.remedy_id}" /></td>
					<td><input
						name="ucmGeneratorInputs[${status.index}].radio_type"
						value="${UCMGeneratorInput.radio_type}" /></td>
					<td><input
						name="ucmGeneratorInputs[${status.index}].radio_user_data_type"
						value="${UCMGeneratorInput.radio_user_data_type}" /></td>
					<td><input
						name="ucmGeneratorInputs[${status.index}].radio_user_alias"
						value="${UCMGeneratorInput.radio_user_alias}" /></td>
					<td><input
						name="ucmGeneratorInputs[${status.index}].radio_serial_number"
						value="${UCMGeneratorInput.radio_serial_number}" /></td>
					<td><input name="ucmGeneratorInputs[${status.index}].ucp"
						value="${UCMGeneratorInput.ucp}" /></td>
					<td><input name="ucmGeneratorInputs[${status.index}].zone_id"
						value="${UCMGeneratorInput.zone_id}" /></td>
					<td><input
						name="ucmGeneratorInputs[${status.index}].entity_name"
						value="${UCMGeneratorInput.entity_name}" /></td>
				<td><input
					name="ucmGeneratorInputs[${status.index}].request_no"
					value="${UCMGeneratorInput.request_no}" /></td>
				<td><input
					name="ucmGeneratorInputs[${status.index}].sub_entity"
					value="${UCMGeneratorInput.sub_entity}" /></td>
				<td><input
					name="ucmGeneratorInputs[${status.index}].radio_modulation_type_id"
					value="${UCMGeneratorInput.radio_modulation_type_id}" /></td>
				<td><input
					name="ucmGeneratorInputs[${status.index}].activation_status"
					value="${UCMGeneratorInput.activation_status}" /></td>
				</tr>

			</c:forEach>
		</table>
		<table>
		<c:forEach items="${entityList.entities}"
				var="entity" varStatus="status">
				<tr>
				<td><input
					name="entities[${status.index}].entity_name"
					value="${entity.entity_name}" /></td>
				</tr>
				</c:forEach>
		</table>		
	</form:form>
</body>
</html>