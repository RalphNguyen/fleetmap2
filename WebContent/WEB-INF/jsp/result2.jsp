<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>UCM generation result</title>
</head>
<body>
	<h2>DONE! UCM generation result</h2>
	<table>
		<tr>
			<td>UCM ID</td>
			<td>${ucm_id}</td>
		</tr>
		<tr>
			<td>Remedy ID</td>
			<td>${remedy_id}</td>
		</tr>
		<tr>
			<td>Issued Date</td>
			<td>${id_issued_date}</td>
		</tr>
		<tr>
			<td>Activation Status</td>
			<td>${activation_status}</td>
		</tr>
		<tr>
			<td>Radio id</td>
			<td>${radio_id}</td>
		</tr>
		<tr>
			<td>Radio Serial Number</td>
			<td>${radio_serial_number}</td>
		</tr>
		<tr>
			<td>Radio User Alias</td>
			<td>${radio_user_alias}</td>
		</tr>
		<tr>
			<td>Radio Type</td>
			<td>${radio_type}</td>
		</tr>
		<tr>
			<td>Security Group ID</td>
			<td>${security_group_id}</td>
		</tr>
		<tr>
			<td>Zone id</td>
			<td>${zone_id}</td>
		</tr>
		<tr>
			<td>Radio User Data Type</td>
			<td>${radio_user_data_type}</td>
		</tr>
		<tr>
			<td>Voice Enabled</td>
			<td>${voice_enabled}</td>
		</tr>
		<tr>
			<td>Internconnect Enabled</td>
			<td>${interconnect_enabled}</td>
		</tr>
		<tr>
			<td>Secure Comms Mode</td>
			<td>${secure_comms_mode}</td>
		</tr>
		<tr>
			<td>Radio User Site Access Alias</td>
			<td>${radio_user_site_access_profile_alias}</td>
		</tr>
		<tr>
			<td>UCP</td>
			<td>${ucp}</td>
		</tr>
		<tr>
			<td>SOFT ID</td>
			<td>${soft_id}</td>
		</tr>
	</table>
</body>
</html>