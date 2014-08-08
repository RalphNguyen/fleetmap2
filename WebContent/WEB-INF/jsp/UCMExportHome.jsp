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
	<form:form method="post" action="searchUCMExport.html"
		modelAttribute="UCMExport">
		<table>
			<tr>
				<td>Search by ID issued date?</td>
				<td><form:checkbox
						path="exportSearchInput.searchByIdIssuedDate" checked="checked"></form:checkbox>
				</td>
			</tr>
			<tr>
				<td><form:label path="exportSearchInput.startDate">Start Issued Date</form:label></td>
				<td><form:input path="exportSearchInput.startDate"
						id="datepicker" /></td>

			</tr>
			<tr>
				<td><form:label path="exportSearchInput.endDate">End Issued Date</form:label></td>
				<td><form:input path="exportSearchInput.endDate"
						id="datepicker2" /></td>
			</tr>
			<tr>
				<td>Search by allocated agency?</td>
				<td><form:checkbox path="exportSearchInput.searchByEntity"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:label path="exportSearchInput.entity_name">Allocated Agency</form:label></td>
				<td><form:select path="exportSearchInput.entity_name">
						<form:options items="${UCMExport.entityForm.entities}"
							var="entity" itemValue="entity_name" itemLabel="entity_name"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td>Search by Zone?</td>
				<td><form:checkbox path="exportSearchInput.searchByZoneId"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:label path="exportSearchInput.zone_id">Zone ID</form:label></td>
				<td><form:select path="exportSearchInput.zone_id">
						<form:option value="1">Zone 1</form:option>
						<form:option value="2">Zone 2</form:option>
						<form:option value="3">Zone 3</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Search by Radio Serial Number?</td>
				<td><form:checkbox
						path="exportSearchInput.searchByRadioSerialNumber"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:label path="exportSearchInput.radio_serial_number">Radio Serial Number</form:label></td>
				<td><form:input path="exportSearchInput.radio_serial_number" /></td>
			</tr>
			<tr>
				<td>Search by activation status?</td>
				<td><form:checkbox path="exportSearchInput.searchByStatus"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:label path="exportSearchInput.activation_status">Activation Status</form:label></td>
				<td><form:select path="exportSearchInput.activation_status">
						<form:option value="Registered and Activated" selected="selected">Registered and Activated</form:option>
						<form:option value="Registered and Deactivated">Registered and Deactivated</form:option>
						<form:option value="Deregistered">Deregistered</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Search by Remedy ID?</td>
				<td><form:checkbox path="exportSearchInput.searchByRemedyId"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:label path="exportSearchInput.remedy_id">Remedy ID</form:label></td>
				<td><form:input path="exportSearchInput.remedy_id" /></td>
			</tr>
			<tr>
				<td>Search by Radio ID?</td>
				<td><form:checkbox path="exportSearchInput.searchByRadioId"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:label path="exportSearchInput.radio_id">Remedy ID</form:label></td>
				<td><form:input path="exportSearchInput.radio_id" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Search UCM" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>