<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 MVC Multipe Row Submit - viralpatel.net</title>
</head>
<body>
 
<h2>Spring MVC Multiple Row Form Submit example</h2>
<form:form method="post" action="save.html" modelAttribute="EntityForm">
    <table>
    <tr>
    	<th>No.</th>
        <th>Entity ID</th>
        <th>Entity Name</th>
        <th>Description</th>
        <th>Security Group ID</th>
        <th>Agency ID</th>
    </tr>
    <c:forEach items="${EntityForm.entities}" var="entity" varStatus="status">
        <tr>
            <td align="center">${status.count}</td>
            <td><input name="entities[${status.index}].entity_id" value="${entity.entity_id}"/></td>
            <td><input name="entities[${status.index}].entity_name" value="${entity.entity_name}"/></td>
            <td><input name="entities[${status.index}].description" value="${entity.description}"/></td>
            <td><input name="entities[${status.index}].security_group_id" value="${entity.security_group_id}"/></td>
            <td><input name="entities[${status.index}].agency_id" value="${entity.agency_id}"/></td>
        </tr>
    </c:forEach>
</table>  
<br/>
<input type="submit" value="Save" />
     
</form:form>
</body>
</html>