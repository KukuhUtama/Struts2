<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<h1>Struts 2 ModelDriven example</h1>
<h2>Add Student</h2>
<s:form action="addingStudent">
  <s:textfield name="id" key="label.id" />
  <s:textfield name="firstName" key="label.fname"/>
  <s:textfield name="lastName" key="label.lname"/>
  <s:submit key="label.submit" align="center" />
</s:form>
</body>
</html>