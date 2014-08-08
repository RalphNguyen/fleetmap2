<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 MVC Multipe Row Submit - viralpatel.net</title>
</head>
<body>
<h2>Show Contacts</h2>
<table width="50%">
    <tr>
        <th>Entity ID</th>
        <th>Entity Name</th>
        <th>Description</th>
        <th>Security Group ID</th>
        <th>Agency ID</th>
    </tr>
    <c:forEach items="${EntityForm.entities}" var="entity" varStatus="status">
        <tr>
            <td>${entity.entity_id}</td>
            <td>${entity.entity_name}</td>
            <td>${entity.description}</td>
            <td>${entity.security_group_id}</td>
            <td>${entity.agency_id}</td>
        </tr>
    </c:forEach>
</table>  
<br/>
<input type="button" value="Back" onclick="javascript:history.back()"/>
</body>
</html>