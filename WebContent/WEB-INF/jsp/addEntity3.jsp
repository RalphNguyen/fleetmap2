<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Spring 3 MVC Multipe Row Submit - viralpatel.net</title>
<style>
body {
	background-color: #eee;
	font: helvetica;
}

#container {
	width: 500px;
	background-color: #fff;
	margin: 30px auto;
	padding: 30px;
	border-radius: 5px;
	box-shadow: 5px;
}

.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

label {
	width: 70px;
	display: inline-block;
}

form {
	line-height: 160%;
}

.hide {
	display: none;
}
</style>
<script>
function myFunction()
{
alert("You have selected some text!");
document.getElementById("test").value="haaha" +document.getElementById("zozo").innerHTML;
}
</script>
</head>
<body>

	<h2>Spring MVC Multiple Row Form Submit example</h2>
	<form:form method="post" action="save.html" modelAttribute="testForm2">
		<br />
		<form:select path="entities">
			<form:options items="${testForm2.entities}" var="entity"
				itemValue="entity_name" itemLabel="entity_name" onclick="myFunction()"></form:options>
		</form:select>
		<br />
	</form:form>
	<form:form method="post" action="save.html" modelAttribute="testForm1">
		<br />
		<br />
			Zone:
			<form:select path="zones" >
			<form:options id="zozo" items="${testForm1.zones}" var="zone"
				itemValue="zone_name" itemLabel="zone_name" onclick="myFunction()"></form:options>
		</form:select>
	</form:form>
	<input type="text" id="test" value="hehe">
</body>
</html>