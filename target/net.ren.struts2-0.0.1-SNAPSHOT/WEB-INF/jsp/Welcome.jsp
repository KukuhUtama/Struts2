<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
</head>

<body>
	<h2>Howdy, <s:property value="username" />...!</h2>
	<h2>FirstName : <s:property value="firstName"/></h2>
	<s:url var="logOut" action="logOut" />
	<s:a href="%{logOut}">Log Out</s:a>
</body>
</html>