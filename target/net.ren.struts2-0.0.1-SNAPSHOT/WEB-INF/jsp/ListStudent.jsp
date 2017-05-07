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
               <s:url var="updateUrl" action="getStudentById">
					<s:param name="id">${student.id}</s:param>
				</s:url> 
				<s:a href="%{updateUrl}">Update</s:a>
                </td>
				<td>
                <s:url var="deleteUrl" action="deleteStudent">
					<s:param name="id">${student.id}</s:param>
				</s:url> 
                <s:a href="%{deleteUrl}">Delete</s:a>
                </td> 
			</tr>
		</c:forEach> 
	</table>
	<s:url var="deleteAllUrl" action="deleteAll"/>
	<s:a href="%{deleteAllUrl}">Delete All</s:a>
</body>
</html>