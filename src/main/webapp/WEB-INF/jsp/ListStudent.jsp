<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Student</title>
</head>
<body>
<table cellpadding="5px">
		<tr class="even">
			<th>Id</th>
			<th>Fist Name</th>
			<th>Last Name</th>
			<th>Edit </th>
			<th>Delete </th>
		</tr>
<c:forEach items="${listStudent}" var="student">
			<tr>
				<td><c:out value="${student.id}"/></td>
				<td><c:out value="${student.firstName}"/></td>
				<td><c:out value="${student.lastName}"/></td>
				<td>
             <%--    <s:url id="editURL" action="editUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> --%>
                <s:a href="%{editURL}">Edit</s:a>
                </td>
				<td>
             <%--    <s:url id="deleteURL" action="deleteUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> --%>
                <s:a href="%{deleteURL}">Delete</s:a>
                </td>
			</tr>
		</c:forEach> 
	</table>
</body>
</html>