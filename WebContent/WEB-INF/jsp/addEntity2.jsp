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
</head>
<body>

	<h2>Spring MVC Multiple Row Form Submit example</h2>
	<form:form method="post" action="save.html" modelAttribute="EntityForm">
		<br />
		<label for="entities">Gender: </label>
		<form:select path="entities">
			<form:options items="${EntityForm.entities}" var="entity"
				itemValue="entity_name" itemLabel="entity_name"></form:options>
		</form:select>
		<br />
		<input type="submit" value="Save" />

	</form:form>
</body>
</html>