<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>In here</title>
</head>
<body>
<h1>Hello Here</h1>
<s:form action="Book">
	<s:submit action="addBook" key="label.submit" align="center" />
	<s:submit action="updateBook" key="label.update" align="center" />
	<s:submit action="deleteBook" key="label.delete" align="center" />
</s:form>
</body>
</html>