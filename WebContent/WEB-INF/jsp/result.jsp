<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>UCM generation result</title>
</head>
<body>
	<h2>UCM generation result</h2>
	<form method="post" action="saveUCM.html" modelAttribute="UCMConfiguration">
		<table>
			<tr>
				<td>Remedy ID</td>
				<td><input readonly="readonly" name="remedy_id" value="${remedy_id}"/></td>
			</tr>
			<tr>
				<td>Issued Date</td>
				<td><input readonly="readonly" name="id_issued_date" value="${id_issued_date}"/></td>
			</tr>
			<tr>
				<td>Activation Status</td>
				<td><input readonly="readonly" name="activation_status" value="${activation_status}"/></td>
			</tr>
			<tr>
				<td>Radio id</td>
				<td><input readonly="readonly" name="radio_id" value="${radio_id}"/></td>
			</tr>
			<tr>
				<td>Radio Serial Number</td>
				<td><input readonly="readonly" name="radio_serial_number" value="${radio_serial_number}"/></td>
			</tr>
			<tr>
				<td>Radio User Alias</td>
				<td><input readonly="readonly" name="radio_user_alias" value="${radio_user_alias}"/></td>
			</tr>
			<tr>
				<td>Radio Type</td>
				<td><input readonly="readonly" name="radio_type" value="${radio_type}"/></td>
			</tr>
			<tr>
				<td>Security Group ID</td>
				<td><input readonly="readonly" name="security_group_id" value="${security_group_id}"/></td>
			</tr>
			<tr>
				<td>Zone id</td>
				<td><input readonly="readonly" name="zone_id" value="${zone_id}"/></td>
			</tr>
			<tr>
				<td>Radio User Data Type</td>
				<td><input readonly="readonly" name="radio_user_data_type" value="${radio_user_data_type}"/></td>
			</tr>
			<tr>
				<td>Voice Enabled</td>
				<td><input readonly="readonly" name="voice_enabled" value="${voice_enabled}"/></td>
			</tr>
			<tr>
				<td>Internconnect Enabled</td>
				<td><input readonly="readonly" name="interconnect_enabled" value="${interconnect_enabled}"/></td>
			</tr>
			<tr>
				<td>Secure Comms Mode</td>
				<td><input readonly="readonly" name="secure_comms_mode" value="${secure_comms_mode}"/></td>
			</tr>
			<tr>
				<td>Radio User Site Access Alias</td>
				<td><input readonly="readonly" name="radio_user_site_access_profile_alias" value="${radio_user_site_access_profile_alias}"/></td>
			</tr>
			<tr>
				<td>UCP</td>
				<td><input readonly="readonly" name="ucp" value="${ucp}"/></td>
			</tr>
			<tr>
				<td>SOFT ID</td>
				<td><input readonly="readonly" name="soft_id" value="${soft_id}"/></td>
			</tr>
					<tr>
				<td colspan="2"><input type="submit" value="Save UCM" /></td>
			</tr>
		</table>
		</form>
</body>
</html>