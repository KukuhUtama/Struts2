<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<h1>Struts 2 ModelDriven example</h1>
	<s:if test="%{model.id == 0}">
		<h2>Add Student</h2>
	</s:if>
	<s:else>
		<h2>Update Student</h2>
	</s:else>
	<s:form action="addStudent">
		<s:if test="%{model.id != 0}">
            <s:textfield name="id" key="label.id" value="%{model.id}" />
	   </s:if>
		<s:textfield name="firstName" key="label.fname"
			value="%{model.firstName}" />
		<s:textfield name="lastName" key="label.lname"
			value="%{model.lastName}" />
		<s:if test="%{model.id == 0}">
			<s:submit key="label.submit" align="center"/>
		</s:if>
		<s:else>
			<s:submit key="label.update" align="center" action="updateStudent"/>
		</s:else>
	</s:form>
	
</body>
</html>